import java.util.*;
public class Subtree_of_Another_Tree_572 {
    /*
    两种方法，一种是不断从s树中找有没有可能剩下部分的两颗树相等的，另一种是用preorder的方法。
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //same tree
    public boolean isSubtree(TreeNode s, TreeNode t) {
        //if(t == null) return true;
        if(s == null) return false;
        if(helper(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    public boolean helper(TreeNode s, TreeNode t){
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.val != t.val) return false;
        return helper(s.left, t.left) && helper(s.right, t.right);
    }

}
