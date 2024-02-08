// Perfect Squares

import java.util.Arrays;

public class PerfectSquares {

    public static int numSquares(int n) {

        int[] dp = new int[n + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        // This code snippet calculates the minimum number of perfect squares that sum
        // up to a given number n, using dynamic programming. It iterates through all
        // numbers from 1 to n and calculates the minimum value by comparing the current
        // value with the previous values plus one
        for (int i = 1; i <= n; ++i) {
            int min_val = Integer.MAX_VALUE;

            // This code snippet calculates the minimum value by finding the minimum of the
            // current minimum value and the value obtained by adding 1 to the previous
            // minimum value, for each value of j squared that is less than or equal to i.
            for (int j = 1; j * j <= i; ++j) {
                min_val = Math.min(min_val, dp[i - j * j] + 1);
            }

            dp[i] = min_val;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 13;
        System.out.println("Perfect Squares: " + numSquares(n));
    }
}
