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
    /*public int numSquares(int n) {
        int[] dp = new int[n + 1];
        int last = 1;
        int min = Integer.MAX_VALUE;
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            if (isPerfectSquare(i)){
                dp[i] = 1;
                last = i;
            }else {
                dp[i] = Math.min(dp[i - last] + dp[last], min);
            }
        }
        return dp[dp.length - 1];
    }

    public boolean isPerfectSquare(int target){
        int tmp = (int) Math.sqrt(target);
        return tmp * tmp == target;
    }
    想得不周全，不仅要比较上一个完美平方数，要比较所有的，才能得出最小的，感觉有点类似于coin change，要
    */

    // public int numSquares(int n){
    //     int[] dp = new int[n + 1];
    //     Arrays.fill(dp, Integer.MAX_VALUE);
    //     dp[0] = 0;
    //     for (int i = 1; i < dp.length; i++){
    //         int min = Integer.MAX_VALUE;
    //         int j = 1;
    //         while (i - j*j >= 0){
    //             min = Math.min(min, dp[i - j * j] + 1);//dp[j * j]因为是完美平方数所以肯定是1
    //             j++;
    //         }
    //         dp[i] = min;
    //     }
    //     return dp[dp.length - 1];
    // }
    //第一层是1，4，9，16...第二层是2，5，10，17...但是这个方法非常慢, 可能是因为做太多次multiplication
    // public int numSquares(int n) {
    //     Set<Integer> vis = new HashSet<>();
    //     Queue<Integer> q = new LinkedList<>();
    //     q.offer(n);
    //     for (int level = 0; !q.isEmpty(); level++) {
    //         for (int i = q.size(); i > 0; i--) {
    //             int num = q.poll();
    //             if (num == 0) return level;
    //             for (int j = 1; j * j <= num; j++)
    //                 if (vis.add(num - j * j))
    //                     q.offer(num - j * j);
    //         }
    //     }
    //     return 0;
    // }

    //math 用的位运算


    public int numSquares(int n){
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++){
            int min = Integer.MAX_VALUE;
            int j = 1;
            while (i - j*j > 0){
                min = Math.min(min, dp[i - j * j] + /*dp[j * j]*/1);//dp[j * j]因为是完美平方数所以肯定是1
            }
            dp[i] = min;
        }
        return dp[dp.length - 1];
    }
}
