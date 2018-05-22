import java.util.Arrays;
import java.util.*;
public class Queue_Reconstruction_by_Height_406 {
    /*
    先排序，然后一个个按照前面有几个比他高的人作为index插入list，比如前面有0个人的，就肯定插第一个，但是因为
    原数组已经按身高从高到低排序过了，所以会把同样p[1]的矮的人插到前面来
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> (o1[0] != o2[0] ? (o2[0] - o1[0]) : o1[1] - o2[1]));
        List<int[]> list = new ArrayList<>();
        for (int[] p : people){
            list.add(p[1], p);
        }
        return list.toArray(new int[0][0]);
    }
}
