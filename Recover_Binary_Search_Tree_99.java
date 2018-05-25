import java.util.*;
public class Recover_Binary_Search_Tree_99 {
    /*
    不用交换nodes，交换值就可以了，遍历一次，first node是prev，second是当前node，就能挑出来，就是要注意两个nodes
    连在一起，从而遍历不到的情况
     */
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public void recoverTree(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode tmp = stack.pop();
            if(prev != null && prev.val > tmp.val){
                if(first == null) first = prev;
                second = tmp;//如果只有两个nodes或者两个节点是连在一起的，在队列的末尾，就会遍历不到
            }
            prev = tmp;
            root = tmp.right;
        }

        int v = first.val;
        first.val = second.val;
        second.val = v;
    }
}
