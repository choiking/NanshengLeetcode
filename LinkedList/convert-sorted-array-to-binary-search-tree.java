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
    public TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
    	TreeNode root = new TreeNode(nums[(start + end) / 2]);
    	root.left = buildTree(nums, start, (start + end) / 2 - 1);
    	root.right = buildTree(nums, (start + end) / 2 + 1, end);
    	return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        return buildTree(nums, 0, nums.length - 1);
    }
}

public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int len = nums.length;
        TreeNode root  = new TreeNode(nums[len/2]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, len/2));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, len/2 + 1, len));
        return root;
    }