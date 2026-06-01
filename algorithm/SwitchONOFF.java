package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SwitchONOFF {
    static int n;
    static int[] switches;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        switches = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int studentCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < studentCount; i++) {
            st = new StringTokenizer(br.readLine());

            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                male(num);
            }
            else {
                female(num);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append(switches[i]).append(" ");

            if(i % 20 == 0)
                sb.append("\n");
        }
        System.out.println(sb);
    }

    static void male(int num) {
        for (int i = num; i <= n; i++) {
            toggle(i);
        }
    }

    static void female(int num) {
        toggle(num);
        int left = num - 1;
        int right = num + 1;

        while (left >= 1 && right <= n) {
            if(switches[left] != switches[right])
                break;

            toggle(left);
            toggle(right);

            left--;
            right++;
        }
    }

    static void toggle(int index) {
        if(switches[index] == 0)
            switches[index] = 1;
        else switches[index] = 0;
    }
}
