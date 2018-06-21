import java.util.*;
public class Maximal_Rectangle_85 {
    /*
    84题的follow up
    因为必须是连续的1才能构成矩形，所以可以看成是2d的84题，每一行就是一个heights[]
    如果是连续的1，高度就可以累加，如果不是的话，就归零

     */

    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int cols = matrix[0].length;
        int rows = matrix.length;
        int max = 0;
        int[] heights = new int[cols];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == '1'){
                    heights[j]++;
                }else {
                    heights[j] = 0;
                }
            }
            int area = helper(heights);
            max = Math.max(area, max);
        }
        return max;
    }

    private int helper(int[] row){
        if(row == null || row.length == 0) return 0;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i <= row.length; i++){
            int cur = i == row.length ? 0 : row[i];
            while(!stack.isEmpty() && cur <= row[stack.peek()]){
                int index = stack.pop();
                int height = row[index];
                int area = height * (stack.isEmpty() ? i : (i - 1- stack.peek()));
                max = Math.max(max, area);
            }
            stack.push(i);

        }
        return max;
    }

    //不用辅助函数，不用stack，不过也是把84题融合在一起
    public int maximalRectangle2(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int[] left = new int[col];
        int[] right = new int[col];
        int[] height = new int[col];
        Arrays.fill(right, col);
        int max = 0;

        for (int i = 0; i < row; i++) {
            int cl = 0;
            int cr = col;
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], cl);
                } else {
                    left[j] = 0;
                    cl = j + 1;
                }
            }
            for (int j = col - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], cr);
                } else {
                    right[j] = col;
                    cr = j;
                }
            }

            for (int j = 0; j < col; j++) {
                max = Math.max((right[j] - left[j]) * height[j], max);
            }

        }

        return max;
    }
}
