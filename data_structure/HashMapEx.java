package data_structure;

import java.util.HashMap;

public class HashMapEx {
    public static void main(String[] args) {
        /*
            HashMap은 key와 value를 쌍으로 저장하는 자료구조

            유형:
            빈도수 세기
            특정 값의 개수 저장
            이름-점수 매칭
            숫자-인덱스 저장
            이미 본 값 기록

            기본 함수들:
            put()
            get()
            getOrDefault()
            containsKey()
            remove()
            size()
            isEmpty()
            keySet()
            entrySet()
         */
        HashMap<String, Integer> map = new HashMap<>();

        map.put("apple", 3);
        map.put("banana", 4);
        map.put("melon", 5);

        System.out.println(map);

        map.put("melon", 50);   // 같은 key를 put하면 value가 덮어씌어짐

        System.out.println(map);

        System.out.println(map.get("apple"));
        System.out.println(map.get("orange"));   // 없는 key를 가져오라고 하면 null 반환

        System.out.println(map.containsKey("apple"));
        System.out.println(map.containsKey("orange"));

        //getOrDefault: key값이 있다면 value 가져오고, 없다면 기본값(0)을 가져옴
        System.out.println(map.getOrDefault("apple", 0));
        System.out.println(map.getOrDefault("orange", 0));

    }
}
