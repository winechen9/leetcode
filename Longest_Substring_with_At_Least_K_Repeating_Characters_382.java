import java.util.*;
public class Longest_Substring_with_At_Least_K_Repeating_Characters_382 {
    /*
    divide and conquer的方法：就是递归地去找满足出现了至少k次的substring，算长度
     */
    public int longestSubstring(String s, int k) {
        return helper(s.toCharArray(), 0, s.length(), k);
    }

    public int helper(char[] s, int left, int right, int k) {
        if (right - left < k) {
            return 0;
        }

        int[] count = new int[26];
        for (int i = left; i < right; i++) {
            count[s[i] - 'a']++;
        }

        for (int i = left; i < right; i++) {
            if (count[s[i] - 'a'] < k) {
                int j = i + 1;
                while (j < right && count[s[j] - 'a'] < k) {
                    j++;
                }

                return Math.max(helper(s, left, i, k), helper(s, j, right, k));
            }
        }

        return right - left;
    }

    public int longestSubstring2(String s, int k) {
        int[] count = new int[26];
        int unique = 0, noLessThanK = 0;
        int max = 0;
        int left = 0;
        int right = 0;

        for(int h = 1; h <= 26; h++){//允许出现h个字母,最多26个字母都出现
            Arrays.fill(count, 0);
            left = 0;
            right = 0;
            unique = 0;
            noLessThanK = 0;
            while(right < s.length()){
                if(unique <= h){
                    if(count[s.charAt(right) - 'a']++ == 0) unique++;
                    if(count[s.charAt(right) - 'a'] == k) noLessThanK++;
                    right++;
                }
                if(unique == h && noLessThanK == unique){
                    max = Math.max(max, right - left);
                    //System.out.println("max:" + max);
                }
                if(unique > h){
                    if(count[s.charAt(left) - 'a']-- == k){
                        noLessThanK--;
                    }
                    if(count[s.charAt(left) - 'a'] == 0){
                        unique--;
                    }
                    left++;
                }
            }
        }
        return max;
    }

}
