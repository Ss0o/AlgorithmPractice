package algorithm;

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        for(int cnt : map.values()) {
            answer *= (cnt + 1);
        }

        return answer - 1;
    }
}

public class Clothes {

    public static void main(String[] args) {
        String[][] clothes = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };

        Solution solution = new Solution();
        int result = solution.solution(clothes);

        System.out.println(result);
    }
}
