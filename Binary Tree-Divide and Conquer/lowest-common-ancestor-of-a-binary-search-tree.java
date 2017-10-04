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
    //result must be the middle of middle of p and q, or equals to the higher one.
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0) {//while p and q is on the each side of root.
        root = p.val < root.val ? root.left : root.right;
        }
        return root;
    }
}