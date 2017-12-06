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



    /*result must be the middle of p and q, or equals to the higher one.
    FOR Binary Search Tree!!!! Remember!!!
    so (p.val - res.val) * (q.val - res.val) <= 0!!
    
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        while ((p.val - root.val) * (q.val - root.val) > 0) {
            if (p.val < root.val) {
                root = root.left;
            }
            else {
                root = root.right;
            }
        }
        return root;
    }

    /*
     suitable for all Binary Tree
     DFS
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        //Divide
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        //Conquer
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }        
        return right;
    }
    
    /*
     suitable for all Binary Tree
     BFS
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        Map<TreeNode, TreeNode> parent = new HashMap<> ();//<node, node.parent>
        Queue<TreeNode> queue = new LinkedList<> ();
        queue.add(root);
        parent.put(root,null);
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = queue.remove();
            if (node.left != null) {
                queue.add(node.left);
                parent.put(node.left, node);
            }
            if (node.right != null) {
                queue.add(node.right);
                parent.put(node.right, node);
            }
        }
        List<TreeNode> ancestors = new ArrayList<> ();//store all p's ancestors..
        //Set<TreeNode> ancestors = new HashSet<> ();//or
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        while (!ancestors.contains(q)) {//travel through q's ancestors, to find Joint node with p
            q = parent.get(q);
        }
        return q;
    }




}