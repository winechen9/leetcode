//package forusall;
import java.util.*;

public class removeDuplicateString {
    /*
   1. 给定由3个大写字母，比如 D E F，随机组成的一个字符串，例如“EDFEEFD”,
    "DD" "EE" "FF"这种需要被消除,
    依次得到“EDFFD” -> "EDD" -> "E",
    最后返回“E”.
    也可以是ABCCBBA->ABCCA->ABA
    时空复杂度要求都是O(n)级别

     */
    public String removeSame(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        if (S.length() == 1) {
            return S;
        }

        Deque<Character> q = new ArrayDeque<>();
        q.offerLast(S.charAt(0));
        for (int i = 1; i < S.length(); i++){
            if (q.isEmpty() || q.peekLast() != S.charAt(i)){
                q.offerLast(S.charAt(i));
            }else {
                q.pollLast();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : q){
            sb.append(c);
        }

        return sb.toString();
    }



    //match those character from beginning
//        char[] array = new char[S.length()];
//        //two pointers
//        int index = -1;
//        int end = 0;
//        while(end != array.length) {
//            if (index != -1 && array[index] == S.charAt(end)) {
//                index--;
//                end++;
//                System.out.println("index = " + index + " end = " + end);
//            } else {
//                index++;
//                array[index] = S.charAt(end);
//                end++;
//                System.out.println("index = " + index + " end = " + end);
//                System.out.println(array[index]);
//            }
//        }
//        if (index == -1) {
//            return "";
//        }
//        System.out.println(array);
//        return String.valueOf(array).substring(0, index+1);


//        while (s.length() > 3) {
//            char[] cha = s.toCharArray();
//            int j = 0;
//            for (int i = 1; i < cha.length; i++) {
//                if (cha[i] == cha[i - 1]) {
//                    i++;
//                    if (i == cha.length - 1) {
//                        cha[j] = cha[i];
//                        j++;
//                    }
//                } else {
//                    cha[j++] = cha[i - 1];
//                    if (i == cha.length - 1) {
//                        cha[j] = cha[i];
//                        j++;
//                    }
//                }
//            }
//            s = String.valueOf(cha).substring(0, j);
////            System.out.println(s);
//        }
//
//        if (s.length() == 1) return s;
//        char[] ch = s.toCharArray();
//        int j = 0;
//        for (int i = 0; i < ch.length - 1; i++){
//            if (ch[i] != ch[i + 1]){
//                ch[j] = ch[i];
//                j++;
//                if (i == ch.length - 2){
//                    ch[j] = ch[++i];
//                    j++;
//                }
//            }
//        }
//
//        return String.valueOf(ch).substring(0, j);


    public static void main(String[] args){
        removeDuplicateString o = new removeDuplicateString();
//        String s = "EDFEEFD";
//        String s = "ABCCBBA";
        String s = "aaeeaabbeabeee";
        String res = o.removeSame(s);
        System.out.println(res);
    }
}
