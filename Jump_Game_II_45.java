public class Jump_Game_II_45 {
    /*
    一步没跳的时候，至少要跳第一步。然后是每次都要更新下一步能走到的最远的地方，[2, 1, 4, 4, 3]
    第一步跳的时候最多就只能走到第0 + 2的位置了，然后在这个nextMax之前，更新能走到的最远距离，在第0 + 1步可以走到
    1 + 1的位置，然后在0 + 2的位置可以走到2 + 4的位置，就超过了最后一个位置，就说明一定能走到咯。
     */

    public int jump(int[] nums) {
        if(nums.length <= 1 || nums == null) return 0;
        int jump = 0;
        int max = 0;
        int nextMax = 0;
        for(int i = 0; i < nums.length - 1; i++){
            nextMax = Math.max(i + nums[i], nextMax);
            if(max == i){
                jump++;
                max = nextMax;
                if(max >= nums.length - 1){
                    return jump;
                }
            }
        }
        return -1;
    }
}
