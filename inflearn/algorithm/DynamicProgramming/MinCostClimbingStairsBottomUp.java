package inflearn.algorithm.DynamicProgramming;

/**
 * cost = {10, 15, 20} 이 주어졌을 때, 최소 비용으로 계단을 오르는 방법을 구하시오.
 * 계단은 한 번에 한 계단 혹은 두 계단씩 오를 수 있다.
 * 최상단에 도달하면 계단을 밟지 않아도 된다.
 * 최소 비용을 구하시오.
 * bottom-up 방식으로 구현
 */
public class MinCostClimbingStairsBottomUp {
    static int[] dp;
//    static int[] cost = {10, 15, 20};
//    static int[] cost = {10, 15, 20, 17, 1};
    static int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

    public static void main(String[] args) {
        int num = cost.length;

        dp = new int[cost.length + 1];

        System.out.println(minCostClimbingStairs(num));
    }

    private static int minCostClimbingStairs(int num) {
        if (num == 0 || num == 1) {
            dp[num] = 0;
            return 0;
        }

        for (int i = 2; i <= num; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[num];
    }

}