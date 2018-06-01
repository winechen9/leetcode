import java.util.*;

public class Binary_Tree_Upside_Down_156 {
    /*
    画好图，找好指向就比较容易
     */
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null) return root;
        TreeNode newRoot = upsideDownBinaryTree(root.left);

        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }

    public TreeNode upsideDownBinaryTree2(TreeNode root) {
        if(root == null) return root;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null){
            stack.push(root);
            root = root.left;
        }
        TreeNode newRoot = stack.pop();
        TreeNode cur = newRoot;
        while(!stack.isEmpty()){
            TreeNode p = stack.pop();
            cur.left = p.right;
            cur.right = p;
            p.left = null;
            p.right = null;
            cur = p;
        }
        return newRoot;
    }

    public TreeNode upsideDownBinaryTree3(TreeNode root) {
        if(root == null) return null;
        TreeNode prev = null;
        TreeNode right = null;
        while(root != null){
            TreeNode next = root.left;
            root.left = right;
            right = root.right;

            root.right = prev;


            prev = root;
            root = next;
        }

        return prev;
    }
}
