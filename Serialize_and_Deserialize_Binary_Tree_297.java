import java.util.*;
public class Serialize_and_Deserialize_Binary_Tree_297 {
    /*
    用preorder最快，也最简单，也不用考虑分隔符的加法是不是多一个或者少一个，因为反正统一的方式deserialize回去的
    用bfs也可以，用一个queue来存节点。deserialize的时候从list里还原回去，但是queue里只加非null的node。
     */

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeUtil(root, sb);
        System.out.println(sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        LinkedList<String> nodes = new LinkedList<>();
        for(String s : strs) nodes.offer(s);
        TreeNode root = deserializeUtil(nodes);

        return root;

    }

    public TreeNode deserializeUtil(LinkedList<String> nodes) {

        if(nodes.isEmpty() || nodes.peek().equals("#")) {
            if(!nodes.isEmpty()) nodes.poll();
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes.poll()));
        root.left = deserializeUtil(nodes);
        root.right = deserializeUtil(nodes);

        return root;
    }

    public void serializeUtil(TreeNode root, StringBuilder sb) {
        if(root == null) {sb.append("#,");return;}
        sb.append(root.val).append(",");
        serializeUtil(root.left, sb);
        serializeUtil(root.right, sb);
    }

}
