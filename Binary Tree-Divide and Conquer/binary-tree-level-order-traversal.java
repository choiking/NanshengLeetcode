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
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();//the parent node
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                level.add(node.val); 
            }//when this ends, q will store all the level value;
            //add the level
            res.add(level);
        }
        return res;
    }


   //below is standard format of traversal (not so level by level, but in a level order)
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