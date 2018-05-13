public class Hamming_Distance_461 {
    /*
    The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

    Given two integers x and y, calculate the Hamming distance.

    Note:
    0 ≤ x, y < 231.

    Example:

    Input: x = 1, y = 4

    Output: 2

    Explanation:
    1   (0 0 0 1)
    4   (0 1 0 0)
            ↑   ↑

    The above arrows point to positions where the corresponding bits are different.
     */
    public int hammingDistance(int x, int y) {
        int r = x ^ y;
        int count = 0;
        while(r > 0){
            if((r & 1) == 1) count++;
            r >>= 1;
        }
        return count;
    }
    /*
    参考答案
    public int hammingDistance(int x, int y) {
        int ans = 0;
        while (x != 0 || y != 0) {
            if (x % 2 != y % 2) {  //这里一个奇数和一个偶数所以会模不一样，说明他们是不一样的
                ans++;
            }
            x = x / 2;
            y = y / 2;
        }
        return ans;
    }
     */
}
