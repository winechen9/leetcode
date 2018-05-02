import java.util.PriorityQueue;

public class Trapping_Rain_Water_II_407 {
    /*
    Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map,
    compute the volume of water it is able to trap after raining.

    Note:
    Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.

    Example:

    Given the following 3x6 height map:
    [
    [1,4,3,1,3,2],
    [3,2,1,3,2,4],
    [2,3,3,2,3,1]
    ]

    Return 4.

     */

    public int trapRainWater(int[][] heightMap){
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0){
            return 0;
        }
        int m = heightMap.length;
        int n = heightMap[0].length;
        PriorityQueue<Cell> pq = new PriorityQueue<>((c1, c2) -> (c1.height - c2.height));
        boolean[][] visited = new boolean[m][n];
        //初始化pq，先把周围一圈放进pq
        for (int i = 0; i < m; i++){
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int i = 0; i< n; i++){
            pq.offer(new Cell(0, i, heightMap[0][i]));
            pq.offer(new Cell(m - 1, i, heightMap[m - 1][i]));
            visited[0][i] = true;
            visited[m - 1][i] = true;
        }

        //弹出最低的墙，如果没有访问过的墙（即里面的墙）比它矮的话，说明可以兜住水，反之说明没法兜住水，则要把墙往里面收
        int[][] neighbors = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int res = 0;
        while (!pq.isEmpty()){
            Cell tmp = pq.poll();
            for (int[] neigh : neighbors){
                int neighX = tmp.x + neigh[0];
                int neighY = tmp.y + neigh[1];
                if (neighX < 0 || neighX >= m || neighY < 0 || neighY >= n || visited[neighX][neighY]){
                    continue;
                }
                int h = heightMap[neighX][neighY];
                res += (h < tmp.height ? tmp.height - h : 0);
                visited[neighX][neighY] = true;
                pq.offer(new Cell(neighX, neighY, (h < tmp.height ? tmp.height: h)));
            }
        }
        return res;
    }

    class Cell {
        int x;
        int y;
        int height;

        public Cell(int x, int y, int height){
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }

}


