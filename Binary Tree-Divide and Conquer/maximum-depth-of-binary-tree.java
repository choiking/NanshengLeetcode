/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//version 1: Divide and Conquer
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {// null or left
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
}
    }
