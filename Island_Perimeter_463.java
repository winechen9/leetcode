public class Island_Perimeter_463 {
    /*
    最简单好理解的方法就是check每个land的地方是不是顶格或者是不是邻居是水，是的话，说明这条边肯定能派上用场，加一就可以了

     */
    int[][] dirs = new int[][]{{1,0}, {-1, 0}, {0, 1}, {0, -1}};
    public int islandPerimeter(int[][] grid) {
        int peri = 0;
        //boolean[][] dupl = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    peri += check(grid, i, j);
                }
            }
        }
        return peri;
    }

    private int check(int[][] grid, int i, int j){
        //dupl[i][j] = true;
        int count = 0;
        for(int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            if((x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0)) count++;

        }
        return count;
    }

    /*
    public int islandPerimeter(int[][] grid) {
        int M = grid.length, N = grid[0].length;

        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;
                    if (i > 0 && grid[i - 1][j] == 1) perimeter -= 2;
                    if (j > 0 && grid[i][j - 1] == 1) perimeter -= 2;
                }
            }
        }
        return perimeter;
    }
     */
}
