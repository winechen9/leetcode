import java.util.*;
public class Max_Stack_716 {
    /*
    最好想的是用一个pq来存最大值，但是remove的时间复杂度较高，再用一个stack来存普通的值
    或者用两个stack，但是popmax的时候要同时更新stack和maxStack,因为这maxStack是不能保证第二大的值在后一个的，所以要把
    这之前的所有值都进行比较一下，因为本来这部分的值都被cover了，max都是原先的max。
     */

    Stack<Integer> stack;
    Stack<Integer> max;
    /** initialize your data structure here. */
    public Max_Stack_716() {
        this.stack = new Stack<>();
        this.max = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(max.isEmpty() || max.peek() <= x){
            max.push(x);
        }
    }

    public int pop() {
        int res = stack.pop();
        if(max.peek() == res){
            max.pop();
        }
        return res;
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return max.peek();
    }

    public int popMax() {
        int res = max.pop();
        Stack<Integer> tmp = new Stack<>();
        while(stack.peek() != res){
            tmp.push(stack.pop());
        }
        stack.pop();
        while(!tmp.isEmpty()){
            push(tmp.pop());
        }
        return res;
    }
}
