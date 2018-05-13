public class Longest_Substring_With_At_Most_k_Distinct_Characters_340 {
    /*
    这道题只涉及自己，所以不需要先遍历一遍填count，只要一边填一边看有没有超过最大限度的k个distinct characters。
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s.equals("")) return 0;
        int[] count = new int[128];
        int unique = 0;
        int max = 0;
        for(int i = 0, j = 0; i < s.length(); i++){
            int len = 0;

            if(count[s.charAt(i)]++ == 0){
                unique++;
            }
            if(unique <= k){
                len = i - j + 1;
                max = Math.max(max, len);
            }

            while(unique > k){
                if(--count[s.charAt(j++)] == 0){
                    unique--;
                }

            }
        }
        return max;
    }
}
