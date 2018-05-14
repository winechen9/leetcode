import java.util.*;
public class Kth_Smallest_Element_in_a_Sorted_Matrix_378 {
    /*
    Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

    Note that it is the kth smallest element in the sorted order, not the kth distinct element.

    Example:

    matrix = [
    [ 1,  5,  9],
    [10, 11, 13],
    [12, 13, 15]
    ],
    k = 8,

    return 13.
    Note:
    You may assume k is always valid, 1 ≤ k ≤ n2.
     */
    /*
    第一次写直接写了个pq，时间复杂度就是O(n^2log(n))，很慢，因为没有利用这个sorted matrix的性质，所以要改进一下
     */
    class Tuple1 {
        int x;
        int y;
        int val;

        public Tuple1(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    public int kthSmallest1(int[][] matrix, int k) {
        PriorityQueue<Tuple1> pq = new PriorityQueue<>((t1, t2) -> t2.val - t1.val);
        for(int i =0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                pq.offer(new Tuple1(i, j, matrix[i][j]));
                if(pq.size() > k){
                    pq.poll();
                }
            }
        }
        return pq.peek().val;
    }
    /*
    改良后的pq方法，先只加第一行进去,发现如果implement Comparable interface直接override compareTo方法会比在pq
    里面加comparator
    快很多。。
     */
    class Tuple implements Comparable<Tuple> {
        int x, y, val;
        public Tuple (int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo (Tuple that) {
            return this.val - that.val;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        int n = matrix.length;
        for(int i = 0; i < n; i++){
            pq.offer(new Tuple(0, i, matrix[0][i]));
        }
        for(int i = 0; i < k - 1; i++){//因为是第k个最小值，所以用minHeap，一直弹k - 1次，因为可以确保每次加的值都是最小的，
            // 所以弹了k - 1次之后栈顶的就肯定是kth smallest element了。后面的数字就用不上了。
            if(!pq.isEmpty()){
                Tuple tmp = pq.poll();
                if(tmp.x != n - 1){
                    pq.offer(new Tuple(tmp.x + 1, tmp.y, matrix[tmp.x + 1][tmp.y]));
                }
            }

        }

        return pq.peek().val;
    }
    /*
    看到sorted list就想到binary search
     */
    public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;

        int start = matrix[0][0];
        int end = matrix[n - 1][n - 1] + 1;
        while(start < end){
            int mid = start + (end - start)/2;
            int count = 0;
            int right = n - 1;
            for(int i = 0; i < n; i++){
                while(right >= 0 && matrix[i][right] > mid){
                    right--;
                }
                count += (right + 1);
            }
            if(count < k){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return start;
    }
}
