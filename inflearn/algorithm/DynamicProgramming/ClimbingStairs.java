package inflearn.algorithm.DynamicProgramming;

public class ClimbingStairs {
    static int stairNum = 6;
    static int[] dp = new int[stairNum + 1];

    public static void main(String[] args) {
        dp[1] = 1;
        dp[2] = 2;

//        System.out.println(climbStairsBtoomUp(5));
        System.out.println(climbStairsTopDown(stairNum));
    }

    private static int climbStairsTopDown(int stairNum) {
        if (stairNum == 1 || stairNum == 2) {
            return dp[stairNum];
        }

        dp[stairNum] = climbStairsTopDown(stairNum - 1) + climbStairsBtoomUp(stairNum - 2);

        return dp[stairNum];
    }

    private static int climbStairsBtoomUp(int n) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            // dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
