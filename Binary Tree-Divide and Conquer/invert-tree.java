class Solution {//BFS  standard BFS format
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<> ();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode n = q.remove();
            TreeNode temp = n.left;
            n.left = n.right;
            n.right = temp;
            if (n.left != null) {
                q.add(n.left);
            }
            if (n.right != null) {
                q.add(n.right);
            }
        }
        return root;
    }
    //DFS
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

    }