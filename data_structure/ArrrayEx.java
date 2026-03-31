package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ArrrayEx{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println("arr: " + Arrays.toString(arr));    // 배열 빠르게 확인

        Arrays.sort(arr);  // 정렬

        System.out.println("arr(정렬): " + Arrays.toString(arr));

        int[] copy = Arrays.copyOf(arr, arr.length);   //원본 유지하고 배열 복사하고 싶을 때 Arrays.copyOf
        System.out.println("copy: " + Arrays.toString(copy));

        int[] visited = new int[5];
        Arrays.fill(visited, -1);     // 배열 -1로 채우기
        System.out.println("visited: " + Arrays.toString(visited));


        int idx = Arrays.binarySearch(arr, 2); // 이진탐색(배열, 찾을 키값) 반환: 키의 인덱스값
        System.out.println(idx); // 없으면 음수 출력
    }

}
