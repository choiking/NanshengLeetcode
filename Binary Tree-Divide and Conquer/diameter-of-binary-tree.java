/*
For every node, length of longest path which pass it = MaxDepth of
its left subtree + MaxDepth of its right subtree.

*/



public class Solution {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        /*
        To clearify, the longest path doesn't have to go through the root node.
So, that's why it update the max in case  the longest path doesn't have to go through the root node like below
 max = Math.max(max, left + right);
which is the tricky part!
        */
        //update max, may choose max still when longest path doesn't have to go through the root
        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }
}


//my Solution
