package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountString {
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
    }
}
