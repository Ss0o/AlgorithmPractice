package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stairs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < n; i++) {
            if(i==0) dp[i] = stairs[i];
            else if(i==1) dp[i] = dp[0] + stairs[i];
            else if(i==2) dp[i] = Math.max(stairs[0]+stairs[i], stairs[1]+stairs[i]);
            else dp[i] = Math.max(dp[i-2] + stairs[i], dp[i-3] + stairs[i-1] + stairs[i]);

        }
        System.out.println(dp[n-1]);

    }
}
