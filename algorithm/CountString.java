package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountString {
    // 함수로 만들기 + startsWith 사용
    public static int countSubString(String str, String target) {
        int cnt = 0;
        for (int i = 0; i <= str.length() - target.length(); i++) {
            if(str.startsWith(target, i))
                cnt++;
        }
        return cnt;
    }
    // 중복해서 안세기 ex) str: aaaa, target: aa 일 경우 cnt=2
    public static int countSubStringNoDuplication(String str, String target) {
        int cnt = 0;
        for (int i = 0; i <= str.length() - target.length(); ) {
            if(str.substring(i, i + target.length()).equals(target)) {
                cnt++;
                i+=target.length();
            }
            else
                i++;
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();     // banana
        String target = br.readLine();  // ana

        int cnt = 0;
        for (int i = 0; i <= str.length() - target.length(); i++) {  // <= '부등호 조심'/ '='까지 해줘야 함
            if(str.substring(i, i + target.length()).equals(target))
                cnt++;
        }

        System.out.println("cnt = " + cnt);

        str = "aaaa";
        target = "aa";
        System.out.println(countSubString(str,target));
        System.out.println(countSubStringNoDuplication(str,target));

    }
}
