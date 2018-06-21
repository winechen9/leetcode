import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Arrays;

public class Task_Scheduler_621 {
    /*
    一种pq的方法，就是把freq们放到一个pq中，从大到小排序，然后每一轮（以n + 1为一个窗口）就是把pq中高频任务依次加入，
    如果没有任务了，就是idle的状态。每次pq只用一次，把里面的任务弹出来，并且任务减一，因为已经做掉了一个了，临时加入
    一个list，结束后再加回去pq，进行下一轮的调度
     */
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        int times = 0;
        for (char c : tasks) {
            map[c - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b - a);
        for (int freq : map) {
            pq.offer(freq);
        }
        while (!pq.isEmpty()) {//任务还没有完全加入完
            List<Integer> tmp = new ArrayList<>();
            int start = 0;
            while (start <= n) {
                if (!pq.isEmpty()) {
                    if (pq.peek() > 1) {
                        tmp.add(pq.poll() - 1);
                    }else {
                        pq.poll();
                    }
                }
                times++;
                if (pq.isEmpty() && tmp.size() == 0) break;//所有任务在这个n interval完成之前就做完了
                start++;
            }
            for (int t : tmp) {
                pq.offer(t);
            }
        }
        return times;
    }

    // sort
    //ans = (k - 1)groups * (n + 1)numbers + p(最后闲散的任务数)
    //因为最后一组无所谓，不一定要完成n个interval，因为是每隔n interval，所以是每个里面是n + 1个。k是最频繁任务的频率
    //求max是求完全没有idle的情况下的length（即task本身的长度）和有idle的情况，哪个更大
    public int leastInterval2(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }
        Arrays.sort(count);
        int i = 25;
        while (i >= 0 && count[i] == count[25]) {
            i--;
        }
        int cur = (count[25] - 1) * (n + 1) + 25 - i;
        return Math.max(cur, tasks.length);
    }
}
