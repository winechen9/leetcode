import java.util.*;
public class Random_Pick_Index_398 {
    int[] nums;
    Random rmd;
    public Random_Pick_Index_398(int[] nums) {
        this.nums = nums;
        this.rmd = new Random();
    }

    public int pick(int target) {
        int count = 0;
        int idx = -1;
        for(int i = 0; i < nums.length; i++){
            if(target != nums[i]){
                continue;
            }
            if(rmd.nextInt(count + 1) == count){//按照count来抽，这样抽的次数控制在count次，不会多抽
                idx = i;
            }
            count++;
        }
        return idx;
    }
}
