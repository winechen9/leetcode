import java.util.*;
public class Insert_Interval_57 {
    /*
    关键在于要一直更改newInterval的start和end，并且考虑到完全没有重叠的情况，一种是出现在中间，一种是出现在末尾

     */
    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        for(Interval i : intervals){
            if(newInterval == null || i.end < newInterval.start){
                res.add(i);
            }else if(i.start > newInterval.end){//完全没有重合的一段
                res.add(newInterval);
                res.add(i);
                newInterval = null;
            }else {
                newInterval.start = Math.min(i.start, newInterval.start);
                newInterval.end = Math.max(newInterval.end, i.end);
            }
        }
        //如果是最后的话
        if(newInterval != null){
            res.add(newInterval);
        }
        return res;
    }
}
