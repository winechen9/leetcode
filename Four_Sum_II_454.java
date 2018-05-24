import java.util.*;
public class Four_Sum_II_454 {
    /*
    拆成两个N^2的循环，把某个数出现的个数存在map中。
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if(A.length == 0 || B.length == 0 || C.length == 0 || D.length == 0) return 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                int tmp = A[i] + B[j];
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            }
        }

        for(int i = 0; i < C.length; i++){
            for(int j = 0; j < D.length; j++){
                int tmp = -(C[i] + D[j]);
                if(map.containsKey(tmp)){
                    count += map.get(tmp);
                }
            }
        }
        return count;
    }
}
