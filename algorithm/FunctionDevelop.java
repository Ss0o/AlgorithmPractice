package algorithm;
import java.util.*;
// 프로그래머스 lv2 기능개발
class Solution_fd {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int day = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
            queue.add(day);
        }

        while (!queue.isEmpty()) {
            int n = queue.poll();
            int cnt = 1;

            while (!queue.isEmpty() && queue.peek() <= n) {
                cnt++;
                queue.poll();
            }
            answer.add(cnt);
        }

        int[] result = new int[answer.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = answer.get(i);
        }
        return result;
    }
}
public class FunctionDevelop {
    public static void main(String[] args) {
        Solution_fd solution = new Solution_fd();

        int[] progresses1 = {93, 30, 55};
        int[] speeds1 = {1, 30, 5};

        int[] result1 = solution.solution(progresses1, speeds1);
        System.out.println(Arrays.toString(result1)); // [2, 1]

        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};

        int[] result2 = solution.solution(progresses2, speeds2);
        System.out.println(Arrays.toString(result2)); // [1, 3, 2]
    }
}
