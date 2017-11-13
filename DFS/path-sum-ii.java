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
    // 遇到sum的题可以逆向思维，即初始值为sum， 结果 = 0；
    //记住这个dfs 的标准模版。helper functiom；
    //记住 path 必须是add的一个拷贝值；
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<> ();
        List<Integer> path = new ArrayList<> ();
        if (root != null) {
            buildPath(root, sum, path, res);
        }
        return res;
    }
    
    public void buildPath(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            res.add(new ArrayList<Integer> (path));
            return;
        }
        if (root.left != null) {
            buildPath(root.left, sum - root.val, path, res);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            buildPath(root.right, sum - root.val, path, res);
            path.remove(path.size() - 1);
        }
    }
    
    
    
}