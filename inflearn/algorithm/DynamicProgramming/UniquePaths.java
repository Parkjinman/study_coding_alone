package inflearn.algorithm.DynamicProgramming;

public class UniquePaths {
    static int[][] dp = null;
    static int uniquePaths = 0;

    public static void main(String[] args) {
        int m = 3;
        int n = 2;

        dp = new int[m+1][n+1 ];

        System.out.println(uniquePathsBottomUp(m, n));
    }

    private static int uniquePathsTopDown(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }

        if (dp[m][n] != 0) {
            return dp[m][n];
        }

        dp[m][n] = uniquePathsTopDown(m-1, n) + uniquePathsTopDown(m, n-1);

        return dp[m][n];
    }

    private static int uniquePathsBottomUp(int m, int n) {

        for (int i = 1; i <= m; i++) {
            dp[i][1] = 1;
        }

        for (int i = 1; i <= n; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m][n];

    }

}
