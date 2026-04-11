package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
    {}{}{{}{}}
    }{
    {{}{}}
 */

public class Brackets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int line = 1;
        while(!s.contains("-")) {

            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if(ch == '{')
                    stack.push(ch);
                else {
                    if(!stack.isEmpty() && stack.peek() == '{')
                        stack.pop();
                    else
                        stack.push(ch);
                }
            }

            int answer = 0;
            while(!stack.isEmpty()) {
                char first = stack.pop();
                char second = stack.pop();

                if(first == second) answer++;
                else answer+=2;
            }
            System.out.println(line + ". " + answer);
            line++;
            s = br.readLine();
        }
    }
}
