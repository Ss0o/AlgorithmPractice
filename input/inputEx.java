package input;


import java.util.Scanner;

/*
    코딩테스트에 필요한 입출력을 정리
    1. Scanner
    2. BufferedReader
    3. StringBuilder
 */
public class inputEx {

    public static void main(String[] args) {
        // 1. Scanner
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();    // 정수값 입력받기
        System.out.println(n);

        String str = sc.next();  // 공백 전까지 한 단어 입력
        System.out.println(str);

        sc.nextLine();    // next뒤에 nextLine을 하려면 엔터 한번 비우기

        String line = sc.nextLine(); // 한 줄 전체 입력
        System.out.println(line);


    }


}
