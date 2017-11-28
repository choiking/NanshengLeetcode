/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//O (n square) running time, each subTree do a pass Brute Force Way!!!
class Solution {
    boolean found = false;
    public boolean checkEqualTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return false;
        int total = sumOfSubtree(root);
        dfs(root, total);

        return found;
    }

    public void dfs(TreeNode root, int total) {
        if (root == null) return;

        if (root.left != null) {
            int left = sumOfSubtree(root.left);
            if (2 * left == total)  found = true;
            dfs(root.left, total);
        }

        if (root.right != null) {
            int right = sumOfSubtree(root.right);
            if (2 * right == total) found = true;
            dfs(root.right, total);
        }
        return;
    }

    public int sumOfSubtree(TreeNode root) {//O(n)
        if (root == null) return 0;
        return root.val + sumOfSubtree(root.left) + sumOfSubtree(root.right);
    }
}


 class Solution {//O(n) running time, only one pass，对整个树 扫了一遍
     public boolean checkEqualTree(TreeNode root) {
         Map<Integer, Integer> countSum = new HashMap<> ();//<Sum, count of this Sum>
         int sum = getSum(root, countSum);
         if (sum == 0) return countSum.getOrDefault(0, 0) > 1;
         return sum % 2 == 0 && countSum.containsKey(sum / 2);
     }
     
     public int getSum(TreeNode root, Map<Integer, Integer> map) {
         if (root == null) return 0;
         int currSum = root.val + getSum(root.left, map) + getSum(root.right, map);
         map.put(currSum, map.getOrDefault(currSum, 0) + 1);
         return currSum;
     }      
 }

 class Solution {//O(n), 对整个树 扫了两遍
    boolean equal = false;
    long total = 0;
    
    public boolean checkEqualTree(TreeNode root) {
        if (root.left == null && root.right == null) return false;
        total = getTotal(root);
        checkEqual(root);
        return equal;
    }
    
    private long getTotal(TreeNode root) {
        if (root == null) return 0;
        return getTotal(root.left) + getTotal(root.right) + root.val;
    }
    
    private long checkEqual(TreeNode root) {
        if (root == null || equal) return 0;
        
        long curSum = checkEqual(root.left) + checkEqual(root.right) + root.val;
        if (total - curSum == curSum) {
            equal = true;
            return 0;
        }
        return curSum;
    }
}