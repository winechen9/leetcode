import java.util.*;
public class Remove_Invalid_Parentheses_301 {
    /*
    这个做法整体思想是找到右括号比左括号多的地方，然后从头去找不同位置的右括号，如果是连续的右括号就只删第一个
    （否则会有重复），然后分别删掉它们，再进行下一次的递归，直到整个string都是合法的。
    然后再处理左括号太多需要删除的情况，此时就是把chars[]{‘}’,’(‘)}顺序调换一下，reuse一下之前的代码就可以了。
    从左到右处理就可以了，因为括号合不合法只看它前面的部分
     */

    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        remove(s, res, 0, 0, new char[]{'(', ')'});
        return res;
    }

    private void remove(String s, List<String> res, int lastI, int lastJ, char[] chs){
        for(int stack = 0, i = lastI; i < s.length(); i++){
            //进行count，看左括号多还是右括号多
            if(s.charAt(i) == chs[0]) stack++;
            if(s.charAt(i) == chs[1]) stack--;
            if(stack >= 0) continue;
            for(int j = lastJ; j <= i; j++){
                if(s.charAt(j) == chs[1] && (j == lastJ || s.charAt(j - 1) != chs[1])){//判断上一个也不是右括号是为了剪枝避免duplicate,只删第一个右括号(如果是连续的几个右括号的话)
                    remove(s.substring(0, j) + s.substring(j + 1, s.length()), res, i, j, chs);
                }
            }
            return;
        }

        String reversed = new StringBuilder(s).reverse().toString();
        if(chs[0] == '('){
            remove(reversed, res, 0, 0, new char[]{')','('});
        }else {
            res.add(reversed);
        }
    }
}
