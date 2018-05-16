public class Counting_Bits_338 {
    /*
    Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

    Example:
    For num = 5 you should return [0,1,1,2,1,2].

    Follow up:

    It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
    Space complexity should be O(n).
    Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
     */
    public int[] countBits(int num) {
        if(num == 0)return new int[]{0};
        int[] dp = new int[num + 1];
        for(int i = 1; i <= num; i++){
            dp[i] = dp[i >> 1] + (i & 1); //因为每次变1的地方都是2的次方，所以可以推测他们的关系是2倍的关系，也可以从二进制的形式来推断
            //1 10 11 100 101 110 111 1000...
            //10是1后面加一个0（i* 2 + 0偶数），11是1后面加1一个1（i* 2 + 1奇数），100是10后面加1个0，101是10后面加1个1.。。
        }
        return dp;
    }

    public int[] countBits1(int num) {
        int[] ans = new int[num + 1];
        int i = 0, b = 1;
        // [0, b) is calculated
        while (b <= num) {
            // generate [b, 2b) or [b, num) from [0, b)
            while(i < b && i + b <= num){
                ans[i + b] = ans[i] + 1;
                ++i;
            }
            i = 0;   // reset i
            b <<= 1; // b = 2b
        }
        return ans;
    }
}
