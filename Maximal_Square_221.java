public class Maximal_Square_221 {
    /*
    Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

    Example:

    Input:

    1 0 1 0 0
    1 0 1 1 1
    1 1 1 1 1
    1 0 0 1 0

    Output: 4

    典型dp题，当一个点为'1'的时候，则至少是一个正方形，再判断周围的三个点是不是也是'1'，是的话则构成一个正方形，边长
    相应递增
    进行到后面的时候，则找周围的三个方向的值中的最小值，dp[i][j]是以当前方块为右下角的正方形的边长
    要注意这是一个char[][]，而不是整数矩阵。。
    要注意dp的index和matrix始终相差1
    */
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(matrix[i - 1][j - 1] == '1'){
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }

}
