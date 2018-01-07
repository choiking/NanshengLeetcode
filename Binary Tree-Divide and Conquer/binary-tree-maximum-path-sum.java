/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// maxPathDown = Math.max(Math.max(left + right) + node.val);
// maxValue = Math.max(maxValue, left + right + node.val);

public class Solution {
    int maxValue;
    
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }
    
    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        //if left or right is negative, just delete it (by declaring it 0)
        maxValue = Math.max(maxValue, Math.max(0, maxPathDown(node.left)) + 
            Math.max(0, maxPathDown(node.right)) + node.val);
        return Math.max(Math.max(0, maxPathDown(node.left)), Math.max(0, maxPathDown(node.right))) + root.val;
    }
}


p