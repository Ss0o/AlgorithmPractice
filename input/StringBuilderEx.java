package input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StringBuilderEx {
    public static void main(String[] args)throws IOException {

        // StringBuilder
        StringBuilder sb = new StringBuilder();

        sb.append("Hello");
        sb.append(" ");
        sb.append("Java");

        System.out.println(sb.toString());

        // 줄바꿈이랑 함께 사용
        StringBuilder sb1 = new StringBuilder();

        sb1.append("첫째 줄").append('\n');
        sb1.append("둘째 줄").append('\n');
        sb1.append("셋째 줄").append('\n');

        System.out.print(sb1);

        // 반복문 사용 예시
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            sb2.append(i+1).append(' ');
        }
        System.out.println(sb2);


        /* 예제: 첫 번째 줄에는 입력 받을 개수 ex) 5
                두 번째 줄에는 입력 값들     ex) 1 2 3 4 5
                출력은 입력 받은 값들의 총합
           BufferedReader, StringTokenizer, StringBuilder를 사용할 것
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        stb.append("입력된 숫자들: ").append('\n');
        for (int i = 0; i < n; i++) {
            stb.append(arr[i]).append(' ');
        }

        stb.append('\n');

        stb.append("합계: ").append(sum).append('\n');

        System.out.println(stb);



    }

}
