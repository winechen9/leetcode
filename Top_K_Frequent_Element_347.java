import java.util.*;
public class Top_K_Frequent_Element_347 {
    /*
    Given a non-empty array of integers, return the k most frequent elements.

    For example,
    Given [1,1,1,2,2,3] and k = 2, return [1,2].

    Note:
    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
    Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
     */

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List[] freqBit = new List[nums.length + 1];
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int v = entry.getValue();
            if (freqBit[v] == null) freqBit[v] = new ArrayList();
            freqBit[v].add(entry.getKey());
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = freqBit.length - 1; i > 0 && k > 0; i--){
            if (freqBit[i] != null){
                List<Integer> list = freqBit[i];
                for (int j : list){
                    if (k == 0) break;
                    res.add(j);
                    k--;
                }
            }
        }
        return res;
    }
}
