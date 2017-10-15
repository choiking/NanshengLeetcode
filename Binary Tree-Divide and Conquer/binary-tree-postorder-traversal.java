/*
using stack.

using linkedList data structure particularly for post order

left - right - root ----->   root  - right - left


*/





class Solution {
    LinkedList<Integer> res = new LinkedList<> ();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return res;
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<> ();
        while (!stack.empty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                res.addFirst(curr.val);
                curr = curr.right;
            }
            curr = stack.pop();
            curr = curr.left;
        }
        return res;
    }
    