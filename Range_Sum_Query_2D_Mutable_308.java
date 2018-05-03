public class Range_Sum_Query_2D_Mutable_308 {
    /*
    Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined
    by its upper left corner (row1, col1) and lower right corner (row2, col2).

    Example:
    Given matrix = [
    [3, 0, 1, 4, 2],
    [5, 6, 3, 2, 1],
    [1, 2, 0, 1, 5],
    [4, 1, 0, 1, 7],
    [1, 0, 3, 0, 5]
    ]

    sumRegion(2, 1, 4, 3) -> 8
    update(3, 2, 2)
    sumRegion(2, 1, 4, 3) -> 10
    Note:
    The matrix is only modifiable by the update function.
    You may assume the number of calls to update and sumRegion function is distributed evenly.
    You may assume that row1 ≤ row2 and col1 ≤ col2.
     */
    private int[][] bit;
    private int[][] m;

    public Range_Sum_Query_2D_Mutable_308(int[][] matrix){
        if (matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        //建bit矩阵大一位，为了使用i & (-i)的公式
        this.bit = new int[matrix.length + 1][matrix[0].length + 1];
        this.m = matrix;

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                init(i, j, matrix[i][j]);
            }
        }
    }
    //只要更新差值就可以了
    public void update(int row, int col, int val){
        int diff = val - m[row][col];
        m[row][col] = val;
        init(row, col, diff);
    }
    //就和一维的一样的操作，只不过多了一层嵌套
    public int sumRange(int rowStart, int colStart, int rowEnd, int colEnd){
        return sum(rowEnd, colEnd) + sum(rowStart - 1, colStart - 1) - sum(rowStart - 1, colEnd)
                - sum(rowEnd, colStart - 1);
    }
    //initialize是从左往右累加，建树的过程
    public void init(int row, int col, int val){
        for (int i = row + 1; i <= m.length; i += i & (-i)){
            for (int j = col + 1; j <= m[0].length; j += j & (-j)){
                bit[i][j] += val;
            }
        }
    }
    //sum是从右往左找有多少个在这个范围内的已经加总的和，再求和
    public int sum(int row, int col){
        int sum = 0;
        for (int i = row + 1; i > 0; i -= i & (-i)){
            for (int j = col + 1; j > 0; j -= j & (-j)){
                sum += bit[i][j];
            }
        }
        return sum;
    }
}
