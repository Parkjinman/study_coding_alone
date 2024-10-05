package inflearn.algorithm.DynamicProgramming;

import java.util.Arrays;

/**
 * cost = {10, 15, 20} 이 주어졌을 때, 최소 비용으로 계단을 오르는 방법을 구하시오.
 * 계단은 한 번에 한 계단 혹은 두 계단씩 오를 수 있다.
 * 최상단에 도달하면 계단을 밟지 않아도 된다.
 * 최소 비용을 구하시오.
 * top-down 방식으로 구현
 */
public class MinCostClimbingStairsTopDown {
    static int[] dp;
//    static int[] cost = {10, 15, 20};
    static int[] cost = {10, 15, 20, 17, 1};
//    static int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

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

    class Solution {
        private int[] dp = new int[1001];
        private int costLen = 0;

        public int minCostClimbingStairs(int[] cost) {
            costLen = cost.length;
            Arrays.fill(dp, -1);
            return minCostCalculator(cost.length, cost);
        }

        private int minCostCalculator(int n, int[] cost) {
            if (n == 0 || n == 1) {
                dp[n] = 0;
                return dp[n];
            }

            if (dp[n] != -1) return dp[n];

            dp[n] = Math.min(minCostCalculator(n-1, cost) + cost[n - 1], minCostCalculator(n-2, cost) + cost[n - 2]);

            return dp[n];
        }
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