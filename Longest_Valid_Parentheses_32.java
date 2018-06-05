import java.util.*;
public class Longest_Valid_Parentheses_32 {
    /*
    每次先弹出配对上的那个index，然后计算长度则用stack里还存在的上一个index，如2 - 0（弹出1，还剩2）
    如果碰到一个')'，但是stack里面是空的，则说明没有'('与其对应，则leftMost要向右移，重新开始新一轮的计算
     */
    public int longestValidParentheses(String s) {
        if (s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int leftMost = -1;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                stack.push(i);
            }else {
                if (stack.isEmpty()){
                    leftMost = i;
                }else {
                    stack.pop();
                    if (stack.isEmpty()) maxLength = Math.max(maxLength, i - leftMost);
                    else maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }

}
