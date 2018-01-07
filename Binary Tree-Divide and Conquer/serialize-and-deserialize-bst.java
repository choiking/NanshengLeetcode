
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
    //DFS iterative (using stack)
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        if (root == null) {
            return res.toString();
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr == null) {
                res.append("null,");
            }
            else {
                res.append(curr.val + ",");
                stack.push(curr.right);
                stack.push(curr.left);
            }
        }
        return res.deleteCharAt(res.length() - 1).toString();
    }


    public TreeNode deserialize(String data) {
        if (data == null || data.equals("")) {
            return null;
        }
        String[] input = data.split(",");
        return buildTree(input);
    }
    int index = -1;
    TreeNode buildTree(String[] input) {
        index++;
        if (input[index].equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(input[index]));
        node.left = buildTree(input);
        node.right = buildTree(input);
        return node;
    }

}



//standard leetcode build in version







// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count = 1;
        while (count > 0) {
            TreeNode node = q.poll();
            if (node == null) {
                res.append("null,");
            }
            else {
                count--;
                res.append(node.val + ",");
                q.offer(node.left);
                q.offer(node.right);
                if (node.left != null) count++;
                if (node.right != null) count++;
            }
        }
        return res.deleteCharAt(res.length() - 1).toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        String[] tree = data.split(",");
        return buildTree(tree);
    }
    TreeNode buildTree(String[] tree) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(tree[0]));
        q.offer(root);
        int index = 1;
        while (index < tree.length) {
           TreeNode node = q.remove();
           if (!tree[index].equals("null")) {
               node.left = new TreeNode(Integer.valueOf(tree[index]));
               q.offer(node.left);
           }
            if (++index == tree.length) {
                return root;
            }
            if (!tree[index].equals("null")) {
                node.right = new TreeNode(Integer.valueOf(tree[index]));
                q.offer(node.right);
            }
            index++;
        }
        return root;
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));