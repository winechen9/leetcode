import java.util.*;
public class Daily_Temperatures_739 {
    /*
    用stack做最直观，但是比较慢，用int[]来模拟会快很多
     */
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0) return new int[0];
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int index = stack.pop();
                //System.out.println("index: " + index);
                res[index] = i - index;
            }
            stack.push(i);

        }
        return res;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        int n = temperatures.length, top = -1;
        int[] stack = new int[n];
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int cur = temperatures[i];
            while (top > -1 && temperatures[stack[top]] < cur) {
                res[stack[top]] = i - stack[top--];
            }
            stack[++top] = i;
        }
        return res;
    }
}
