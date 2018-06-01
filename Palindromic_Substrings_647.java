public class Palindromic_Substrings_647 {
    /*
    第五题的变形题，还是蛮简单的，对于每一个char都进行extendPalindrome的操作，加总就可以了

     */
    public int countSubstrings(String s) {
        int res = 0;
        for(int i = 0; i< s.length(); i++){
            res += expandFromCenter(s, i, i);
            if(i < s.length() - 1) res += expandFromCenter(s, i, i + 1);
        }
        return res;
    }

    public int expandFromCenter(String s, int left, int right){
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
            count++;
        }
        return count;
    }

    
}
