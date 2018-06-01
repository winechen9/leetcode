import java.util.*;
public class Find_All_Anagrams_in_a_String_438 {
    /*
    滑窗题套模板，先把短string中的拿出来，加入count进行计数，然后再遍历长string，每遍历到一个在count中已经存在（即>0)的
    char，就count中数目减少，直到所有的短string中出现过的char都已经全部出现（counter减为0），就可以加入结果
    移动left指针的情况要根据具体题目来定。这里是只要长度超过了短string的长度，就要右移left。
    右移left的过程中，不断检查是不是去掉的值是在短string里面的，如果是的话，就加上count的这个char的数目
    已经递增counter的数目。
     */

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] count = new int[128];
        //窗口的大小是p的长度
        for(char c : p.toCharArray()){
            count[c]++;
        }
        int counter = p.length();
        int left = 0;
        int right = 0;
        while(right < s.length()){
            if(count[s.charAt(right++)]-- > 0){//如果是重复值的话，就是要减到等于0,counter才减一
                counter--;
            }
            if(counter == 0){
                res.add(left);
            }
            //如果不是连续的情况，就会left右移，改变counter的数目
            if(right - left >= p.length()){
                if(++count[s.charAt(left++)] > 0){
                    counter++;
                }
            }
        }
        return res;
    }
}
