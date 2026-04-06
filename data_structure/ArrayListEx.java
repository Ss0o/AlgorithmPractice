package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ArrayListEx {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        /*
            ArrayList
            입력 받은 수들을 순서대로 저장
            get(i) 시간복잡도: O(1)
            add(맨 뒤) 시간복잡도: O(1)에 가까움
            add(중간 삽입) 시간복잡도: O(n)
            remove(중간 삭제) 시간복잡도: O(n)
            중간에 넣거나 지우면 뒤의 원소들을 한 칸씩 밀거나 당겨야 해서
            중간 삽입/삭제에 불리, 끝에 추가/인덱스 접근에는 유리

            관련 메서드
            add(E e)          // 맨 뒤에 추가
            add(int idx, E e) // 특정 위치에 삽입

            get(int idx)      // 조회
            set(int idx, E e) // 수정

            remove(int idx)   // 인덱스로 삭제
            숫자 값을 삭제하고 싶으면 remove(Integer.valueOf(1));

            size()            // 크기
            isEmpty()         // 비어있는지
            clear()           // 전체 삭제

            contains(Object o) // 포함 여부
            indexOf(Object o)  // 처음 위치
            lastIndexOf(Object o) // 마지막 위치
            remove()

         */
        ArrayList<Integer> list = new ArrayList<>();

        while(n != -1) {
            list.add(n);
            n = Integer.parseInt(br.readLine());
        }

        System.out.print(list);

        list.add(99);
        System.out.println();

        // System.out.println(list.get(99));  // 인덱스로 조회하므로 이건 안됨
        System.out.println(list.get(list.size()-1)); // size() 사용해서 맨 끝의 인덱스의 해당 값 가져오기
        System.out.println(list);

        //list.remove(99);   // 인덱스에 해당하는 값을 지우는 것이므로 안됨
        list.remove(list.size()-1);
        System.out.println(list);

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("hi");
        list2.add("my");
        list2.add("name");
        list2.add("is");
        System.out.println(list2);
        list2.remove("hi");   // 문자열 arraylist의 경우에는 obj이므로 됨
        System.out.println(list2);


        list.clear();
        System.out.print(list.isEmpty());




    }
}
