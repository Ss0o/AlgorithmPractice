package algorithm;

public class TrafficLight {
    public static void main(String[] args) {
        int[][] signal1 = {{2, 1, 2}, {5, 1, 1}};
        int[][] signal2 = {{2, 3, 2}, {3, 1, 3}, {2, 1, 1}};
        int[][] signal3 = {{3, 3, 3}, {5, 4, 2}, {2, 1, 2}};
        int[][] signal4 = {{1, 1, 4}, {2, 1, 3}, {3, 1, 2}, {4, 1, 1}};

        System.out.println(solution(signal1));
        System.out.println(solution(signal2));
        System.out.println(solution(signal3));
        System.out.println(solution(signal4));

    }

    public static int solution(int[][] signals) {
        long limit = 1;
        for(int[] signal : signals) {
            int cycle = signal[0] + signal[1] + signal[2];
            limit = lcm(limit, cycle);
        }
        for (int i = 1; i <= limit; i++) {
            boolean allYellow = true;
            for (int[] signal : signals) {
                int g = signal[0];
                int y = signal[1];
                int r = signal[2];

                int cycle = g + y + r;

                int pos = (i - 1) % cycle + 1;

                if (!(g < pos && pos <= g + y)) {
                    allYellow = false;
                    break;
                }
            }
            if(allYellow)
                return i;
        }

        return -1;
    }
    private static long gcd(long a, long b) {
        long tmp;
        while(b != 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
    private static long lcm(long a, long b) {
        return a / gcd(a,b) * b;
    }
}
