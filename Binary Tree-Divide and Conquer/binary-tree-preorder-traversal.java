/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//version 1 traversal
class Solution {
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return res;
}
}


class Solution {// version 2: Divide and Conquer
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        //Divide
        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);
        
        //Conquer
        res.add(root.val);
        res.addAll(left);
        res.addAll(right);
        return res;
}
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution { //version 3: using stack, no recursion BFS
    //stack is different from queue in order because stack is FILO, queue is FIFO
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        if (root == null) return res;
        stack.push(root);
        
        while (!stack.empty()) {
            TreeNode temp = stack.pop();
            res.add(temp.val);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        return res;
    }
}
