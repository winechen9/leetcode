public class Longest_Increasing_Path_in_a_Matrix_329 {
    /*
    Given an integer matrix, find the length of the longest increasing path.

    From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

    Example 1:

    nums = [
    [9,9,4],
    [6,6,8],
    [2,1,1]
    ]
    Return 4
    The longest increasing path is [1, 2, 6, 9].

    Example 2:

    nums = [
    [3,4,5],
    [3,2,6],
    [2,2,1]
    ]
    Return 4
    The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
     */
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] helper = new int[m][n];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int len = dfs(matrix, helper, m, n, i, j, Integer.MIN_VALUE);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int[][] helper, int m, int n, int row, int col, int min){
        if(row < 0 || row >= m || col < 0 || col >= n || matrix[row][col] <= min){
            return 0;
        }
        int max = 1;
        if(helper[row][col] != 0) return helper[row][col];//如果已经有这个数字存在说明已经访问过了，因为长度至少为1，所以不会有歧义
        //不会存在取不到最大值的情况，因为dfs每次都直接找到了某个点开始的最长的值
        int len1 = dfs(matrix, helper, m, n, row + 1, col, matrix[row][col]) + 1;//每次都记住上一个数字，进行大小的比较
        int len2 = dfs(matrix, helper, m, n, row - 1, col, matrix[row][col]) + 1;
        int len3 = dfs(matrix, helper, m, n, row, col + 1, matrix[row][col]) + 1;
        int len4 = dfs(matrix, helper, m, n, row, col - 1, matrix[row][col]) + 1;
        max = Math.max(len1, Math.max(len2, Math.max(len3, len4)));
        helper[row][col] = max;
        return max;
    }
}
