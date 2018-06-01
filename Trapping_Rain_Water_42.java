import java.util.*;
public class Trapping_Rain_Water_42 {
    /*
    用stack最直观，每次都要把当前的bar的index加入到stack中去，因为这样才可以比较到所有的bar
    two pointers的方法就比较快，在左右边各设一个边界，每次都确保当前这一边一定是较小的那一边，这样凡是比这个小的
    高度都可以被包括进去。
     */
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int water = 0;
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < height.length; i++){
            int curH = height[i];
            while(!s.isEmpty() && height[s.peek()] < curH){

                int base = height[s.pop()];
                if(!s.isEmpty()){
                    water += (Math.min(curH, height[s.peek()]) - base) * (i - s.peek() - 1);
                    //System.out.println(water);
                }
            }
            s.push(i);
        }
        return water;
    }
}
