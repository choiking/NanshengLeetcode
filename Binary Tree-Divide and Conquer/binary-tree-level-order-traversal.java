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
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList res = new ArrayList();
        
        if(root == null) {
            return res;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            //do the level(enqueue)
            for (int i = 0; i < size; i++) {//每层有几个node，就做几次延展。
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                level.add(queue.remove()); 
            }//when this ends, q will store all the level value;
            //add the level
            res.add(level);
        }
        return res;
    }
/*
  DFS solution, when you try to do a traditonally BFS question by DFS, do it adding a height!

*/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<> ();
        if (root == null) {
            return res;
        }
        helper(0, res, root);
        return res;
    }
    
    void helper(int height, List<List<Integer>> res, TreeNode root) {
        if (root == null) {
            return;
        }
        if (height >= res.size()) {//the time to add new level
            res.add(new ArrayList<> ());
        }
        res.get(height).add(root.val);
        helper(height + 1, res, root.left);
        helper(height + 1, res, root.right);
    }




   //below is standard format of traversal (not so level by level, but in a level order)(NOT the solution)
    public void levelOrderQueue(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        if (root == null)  return;
        q.add(root);

        while (!q.isEmpty()) {
            Node n = (Node) q.remove();
            //System.out.print(" " + n.data);
            if (n.left != null) {
                q.add(n.left);
            }
            if (n.right != null) {
                q.add(n.right);
            }
        }
    }






}