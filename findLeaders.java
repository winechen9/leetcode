//package forusall;
import java.util.*;

public class findLeaders {
    /*
    2. 给一个数组，2个数字
    例如int[] A = [1, 2, 3, 3, 1, 2],
    第一个给定数字a 等于3 的话，代表子数组长度为3；
    第二个给定数字b 等于5 的话，代表数组A 里的元素取值在1 到5 之间；
    对所有子数组进行加一处理去找众数(个数达到了子数组元素的一半以上)，
    最后升序返回结果数组。还要去重。
    时空复杂度要求都是O(n)级别

    关于第2题之前说的有点误导大家了。我重新补充一下：
    比如数组是A = [1, 2, 2, 1, 2] a = 4, b = 2.
    A.length = 5, 众数要多于(5 / 2).
    对子数组+1处理，
    得到第一种情况[2，3，3，2，2], 2 符合；
    得到第二种情况[1,  3,   3,  2,  3], 3 符合。
    输出结果[2, 3].

    只有长度为3的子数组是+1之后的，其他的元素保持不变，这样第一次就是在2 3 4 3 1 2里面找。
     */

    public static int[] solution(int K, int M, int[] A) {
        // write your code in Java SE 8
        if(A.length == 0 || A == null) return new int[0];
        int len = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new TreeSet<>((a,b)-> a - b);
        for(int i = 0; i < K; i++){
            A[i]++;
        }

        for(int i = 0; i < len; i++){
            if(!map.containsKey(A[i])){
                map.put(A[i], 1);
            }else {
                if(map.get(A[i])+ 1 > (len / 2)){
                    set.add(A[i]);
                }
                map.put(A[i], map.get(A[i])+ 1);
            }
        }

        for(int i = 0; i <= len - K; i++){
            if(i > 0){
                map.put(A[i - 1], map.getOrDefault(A[i - 1], 0) - 1);
                A[i - 1]--;
                map.put(A[i - 1], map.getOrDefault(A[i - 1], 0) + 1);
                if(map.get(A[i - 1]) > (len / 2 )){
                    set.add(A[i - 1]);
                }
                map.put(A[i + K - 1], map.getOrDefault(A[i + K - 1], 0) - 1);
                A[i + K - 1]++;
                map.put(A[i + K - 1], map.getOrDefault(A[i + K - 1], 0) + 1);
                if(map.get(A[i + K - 1]) > (len / 2 )){
                    set.add(A[i + K - 1]);
                }
            }
        }
        int[] res = new int[set.size()];
        int index = 0;
        for(int num : set){
            res[index] = num;
            index++;
        }
        return res;
    }




    public static void main(String[] argv) {
        findLeaders k = new findLeaders();
//        int[] A = {2, 1, 1, 1, 3, 4, 1, 3, 1};
//        int[] A = {1,2,2,1,1};
//        System.out.println(2 % 1);
        int[] A = {3,3,3,2,1};
        int[] result = k.solution(3, 5, A);
        for (int cur : result) {
            System.out.println(cur);
        }
        int[] a = solution(2,2, A);
    }
}
