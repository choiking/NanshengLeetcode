/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  //recursive solution
    public boolean isSymmetric(TreeNode root) {
        // Write your code here
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        else //按照对称的方向拓展。。
            return left.val == right.val && helper(left.left, right.right) && helper(left.right, right.left);
    }
}

//BFS

public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<> ();
        q.add(root.left);
        q.add(root.right);

        while (q.size() >= 2) {
            TreeNode left = q.poll(), right = q.poll();
            if (left == null && right == null)
                continue;
            if (left == null || right == null)
                return false;
            if (left.val != right.val)
                return false;
            q.offer(left.left);
            q.offer(right.right);
            q.offer(left.right);
            q.offer(right.left);
        }
        return true;
    }
