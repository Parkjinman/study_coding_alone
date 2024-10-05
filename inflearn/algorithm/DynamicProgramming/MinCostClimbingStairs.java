package inflearn.algorithm.DynamicProgramming;

public class MinCostClimbingStairs {
    static int[] dp;
//    static int[] cost = {10, 15, 20};
    static int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

    public static void main(String[] args) {
        int num = cost.length;

        dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = cost[0];
        dp[2] = cost[1];

        System.out.println(minCostClimbingStairs(num));
    }

    private static int minCostClimbingStairs(int num) {
        if (num == 0 || num == 1) {
            return 0;
        }

        dp[num] = Math.min(minCostClimbingStairs(num - 1) + cost[num - 1], minCostClimbingStairs(num - 2) + cost[num - 2]);

        return dp[num];
    }

//    dp = new int[cost.length + 1];
//    dp[0] = 0;
//    dp[1] = 1;
//    dp[2] = 2;

//    private static int minCostClimbingStairs(int num) {
//        if (num == 1 || num == 2) {
//            return dp[num];
//        }
//
//        dp[num] = minCostClimbingStairs(num - 1) + minCostClimbingStairs(num - 2);
//
//        return dp[num];
//    }
}