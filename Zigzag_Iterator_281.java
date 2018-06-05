import java.util.*;
public class Zigzag_Iterator_281 {
    /*
    一个queue，轮着加进去，再弹出来，形成一个顺序
     */
    LinkedList<Iterator> list;
    public Zigzag_Iterator_281(List<Integer> v1, List<Integer> v2) {
        this.list = new LinkedList<>();
        if(!v1.isEmpty()) list.add(v1.iterator());
        if(!v2.isEmpty()) list.add(v2.iterator());
    }

    public int next() {
        Iterator tmp = list.poll();
        int res = (Integer)tmp.next();
        if(tmp.hasNext()){
            list.add(tmp);
        }
        return res;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}
