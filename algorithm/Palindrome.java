package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    ab -> aba
    abc -> abc
    abca ->
    abcqweewq
 */

public class Palindrome {
    public static boolean isPalindrome(String s, int left, int right) {

        while(left < right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int len = s.length();
        for(int i = 0; i < len; i++) {
            if(isPalindrome(s,i,len-1)) {
                System.out.println(len + i);
                return;
            }
        }

    }
}
