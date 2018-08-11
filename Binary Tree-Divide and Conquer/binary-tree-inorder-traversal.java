/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*

1.Iterative solution using stack --- O(n) time and O(n) space;
2.Recursive solution --- O(n) time and O(n) space (considering the spaces of function call stack);
3.Morris traversal --- O(n) time and O(1) space!!!

*/


    /*
  DFS + stack  = iterative

  dfs可以用stack模拟递归
   iterative
*/
    List<Integer> res = new ArrayList();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<> ();
        TreeNode curr = root;
        while (!stack.empty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }//go as deep as possible (so it is a DFS)
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }



    //recursive
    public List<Integer> inorderTraversal(TreeNode root) {
        storeVal(root);
        return res;
    }
    void  storeVal(TreeNode node) {
        if (node != null) {
            if (node.left != null) {
                storeVal(node.left);
            }
            res.add(node.val);
            if (node.right != null) {
                storeVal(node.right);
            }
        }
    }





    void MorrisTraversal(TreeNode root) {
        TreeNode curr, pre;

        if (root == null)
            return;

        curr = root;
        while (curr != null)
        {
            if (curr.left == null) //if left is null, add itself, and assign it to its right
            {
                list.add(curr.val);
                curr = curr.right;
            }

            else
            {
                pre = curr.left;
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }

                if (pre.right == null)
                {
                    pre.right = curr;
                    current = curr.left;
                }

                else
                 {
                    pre.right = null;
                    list.add(curr.val);
                    curr = curr.right;
                }

            }
        }
}
