public class Product_of_Array_Except_Self_238 {
    /*
    要记住第一轮dp里乘的时候每一个值都是自己前面的所有数的乘积，后面的mul就是自己后面的所有数的乘积
    第一个数和最后一个数前面和后面没有数，所以默认为1.
     */
    public int[] productExceptSelf(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i = 1; i < dp.length; i++){
            dp[i] = dp[i - 1] * nums[i - 1];
            // System.out.println(dp[i]);
        }
        int mul = 1;
        for(int i = dp.length - 1; i >= 0; i--){
            dp[i] *= mul; // 每一个dp[i]就是自己前面的总乘积，而mul则是它自己之后的总乘积
            mul *= nums[i];
        }
        return dp;
    }
}
