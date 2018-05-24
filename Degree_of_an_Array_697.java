import java.util.*;
public class Degree_of_an_Array_697 {
    /*
    为了节省空间，要一边遍历数组，记录下最大的degree，还要记下每个值出现过的index，同时做到这点，
    就要用到list的size这个参数，然后这样可以算出第一个出现的
    位置和最后一个出现的位置的距离，就是这个max degree可能的最短长度。
     */
    public int findShortestSubArray(int[] nums) {
        //先找到最大的degree
        int maxDegree = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new ArrayList<>());
            }
            List<Integer> tmp = map.get(nums[i]);
            tmp.add(i);
            map.put(nums[i], tmp);
            maxDegree = Math.max(maxDegree, map.get(nums[i]).size());
        }
        int len = Integer.MAX_VALUE;
        for(List<Integer> l : map.values()){
            if(l.size() == maxDegree){
                len = Math.min(len, l.get(l.size()- 1) - l.get(0) + 1);
            }
        }
        return len;
    }
}
