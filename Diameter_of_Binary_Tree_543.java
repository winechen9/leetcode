import java.util.*;
public class Diameter_of_Binary_Tree_543 {

    /*
    同时只有一个node可以使用左右两边，就是跟Binary Tree Maximum Path Sum一样的，每次定一个node，然后更新一下如果
    两边都使用来求path的话，是多少长度，然后退出来，进行下一步的迭代，此时就只能用左或者右子树的一个长度了。depth是有几个
    节点就有多少深度，所以在这里左右节点的深度加起来正好是path的数目。
     */
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        helper(root);
        return max;
    }
    public int helper(TreeNode root){
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        max = Math.max(max, left + right);
        return 1 + Math.max(left, right);//相当于是计算max depth
    }
}
