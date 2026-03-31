package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountChar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char target = br.readLine().charAt(0);

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == target)
                count++;
        }

        System.out.println("count = " + count);
    }
}
