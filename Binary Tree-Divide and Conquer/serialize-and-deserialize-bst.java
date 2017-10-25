
/*
如果使用preorder 来转换binary tree 到 string， 转回去时也需要用preorder来build tree。



*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
     StringBuilder res = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            res.append("null,");
            return res.toString();
        }
        res.append(root.val).append(",");
        serialize(root.left);
        serialize(root.right);
        return res.substring(0, res.length() - 1);
    }
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("null")) return null;
        String[] tree = data.split(",");
        return buildTree(tree);
    }

    private int rootPosition = 0;
    private TreeNode buildTree(String[] tree) {
        if (tree[rootPosition].equals("null")) {
            rootPosition++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(tree[rootPosition]));
        rootPosition += 1;//使用 idex 从左到右慢慢遍历, root left right 的顺序
        root.left = buildTree(tree);
        root.right = buildTree(tree);
        return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));