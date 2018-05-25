import java.util.Arrays;

public class Perfect_Squares_279 {
    /*
    Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

    Example 1:

    Input: n = 12
    Output: 3
    Explanation: 12 = 4 + 4 + 4.
    Example 2:

    Input: n = 13
    Output: 2
    Explanation: 13 = 4 + 9.


     */

    public int numSquares(int n){
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++){
            int min = Integer.MAX_VALUE;
            int j = 1;
            while (i - j*j > 0){
                min = Math.min(min, dp[i - j * j] + dp[j * j]);//dp[j * j]因为是完美平方数所以肯定是1
            }
            dp[i] = min;
        }
        return dp[dp.length - 1];
    }
}
