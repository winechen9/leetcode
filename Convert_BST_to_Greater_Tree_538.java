import java.util.*;
public class Convert_BST_to_Greater_Tree_538 {
    /*
    充分利用BST的性质，中序遍历得到从小到大的sequence就好。这里正好反过来，是从大到小，所以是反序的中序遍历
     */

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    //recursion
    public TreeNode convertBST(TreeNode root) {
        int[] res = new int[1];
        helper(root, res);
        return root;
    }

    private void helper(TreeNode root, int[] res){
        if(root == null) return;
        helper(root.right, res);
        root.val += res[0];
        res[0] = root.val;
        helper(root.left, res);

    }

    //iterative
    public TreeNode convertBST2(TreeNode root) {
        TreeNode cur = root;
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || cur != null) {
            while(cur!= null){
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            if(prev != null){
                cur.val += prev.val;
            }

            prev = cur;
            cur = cur.left;
        }
        return root;
    }
}
