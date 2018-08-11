/*
using stack.

using linkedList data structure particularly for post order

left - right - root ----->   root  - right - left
addFirst();

*/


class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<> ();
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
            /*
            if (curr !=null)
            else {

            }
            */
        }
        return res;
    }
