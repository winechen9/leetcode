import java.util.*;
public class Linked_List_Random_Node_382 {
    /*
    Given a singly linked list, return a random node's value from the linked list.
    Each node must have the same probability of being chosen.

    Follow up:
    What if the linked list is extremely large and its length is unknown to you?
    Could you solve this efficiently without using extra space?
     */

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    Random rmd;
    ListNode head;
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Linked_List_Random_Node_382(ListNode head) {
        this.rmd = new Random();
        this.head = head;
    }

    /** Returns a random node's value.
     * 第一个node取到的概率是100%，第二个node是50%，第三个是33%。。。*/
    public int getRandom() {
        ListNode cur = head;
        int val = cur.val;
        int index = 0;
        while(cur != null){

            int r = rmd.nextInt(index + 1);
            if(r == index){
                val = cur.val;
            }
            cur = cur.next;
            index++;
        }
        return val;
    }
}
