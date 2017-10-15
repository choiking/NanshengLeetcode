/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *      7
 *    6   8    traversal order 8 - 7 - 6
 *
 */


// when doing a reverse inorder traversal(right-root-left),which is descending order, we keep track of the running sum of every nodes.






class Solution {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        converBST(root.right);
        int temp = root.val;
        root.val += sum;
        sum += temp;
        convertBST(root.left);
    }
    
}