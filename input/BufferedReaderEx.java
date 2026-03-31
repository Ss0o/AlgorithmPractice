package input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BufferedReaderEx {
    public static void main(String[] args) throws IOException {
        // 2.BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine(); // 한 줄 전체를 문자열로 입력받음 (throws IOException 해줘야 함)
        System.out.println(line);

        int n = Integer.parseInt(br.readLine());
        System.out.println(n);


        // 한 줄에 여러개 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        // 배열 입력 받기 (한 줄에 여러 값)
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        for(int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());

        }
        for(int i = 0; i < num; i++) {
            System.out.print(arr[i] + " ");
        }


    }
}
