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
    
    int count = 0;
    int res = Integer.MIN_VALUE;
    public int kthSmallest(TreeNode root, int k) {
        storeVal(root, k);
        return res;
    }
    
    
    /*
    inorder in recursive way
    time O(k)
    space O(k)
    */
    
    void  storeVal(TreeNode node, int k) {
        if (node != null) {
            if (node.left != null) {
                storeVal(node.left, k);
            }
            if (++count == k) {
                res = node.val;
                return;
            }
            if (node.right != null) {
                storeVal(node.right, k);
            }
        }
    }
    
    /*
    inorder in recursive way
    time O(k)
    space O(k)
    */
    void  storeVal(TreeNode node, int k) {
       if (node == null) return;
        Stack<TreeNode> stack = new Stack<> ();
        TreeNode curr = node;
        while (!stack.empty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }//go as deep as possible (so it is a DFS)
            curr = stack.pop();
            if (++count == k) {
                res = curr.val;
                return;
            }
            curr = curr.right;
        }
    }
    /*
      Binary Search
      
      The best performance is we just have to count the nodes for once (i.e. kth is root), which is O(n); the worse/average case when we need count nodes for each subtree traversal, binary search is always log(n), and number of traversed subtrees could be n, then as total is O(nlog(n)).
    */
    public int kthSmallest(TreeNode root, int k) {
         int countLeft = countNode(root.left);
         if (countLeft >= k) {
             return kthSmallest(root.left, k);
         }
         else if (k == countLeft + 1) {
             return root.val;
         }
         else {
             return kthSmallest(root.right, k - countLeft - 1);
         }
    }
    
    //count how many nodes in the tree
    int countNode(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNode(node.left) + countNode(node.right);
    }   
      
    
}