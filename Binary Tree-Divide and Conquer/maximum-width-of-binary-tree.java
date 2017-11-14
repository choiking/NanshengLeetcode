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
    //version using one Queue and one HashMap, BFS
    //the key thing is store very node's position(by creating a HashMap) 
    //if the parent is n, left = 2n, right = 2n + 1(it will not collise), 
    //so every level Len = end - start + 1
    /*
       1
    2    3   this rule make sure every leftmost is always bigger than above level.
  4  5  6  7
    
    */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<> ();
        q.add(root);
        Map<TreeNode, Integer> map = new HashMap<> (); 
        map.put(root, 1);
        int width = 0, max = 0;
        while (!q.isEmpty()) {
            int start = 0, end = 0;
            int levelLen = q.size();
            
            for (int i = 0; i < levelLen; i++) {
                TreeNode node = q.remove();//parent node
                if (i == 0)  start = map.get(node);
                if (i == levelLen - 1)  end = map.get(node);
                    
                if (node.left != null) {
                    q.add(node.left);
                    map.put(node.left, map.get(node) * 2);
                }
                if (node.right != null) {
                    q.add(node.right);
                    map.put(node.right, map.get(node) * 2 + 1);
                }
            }//when this ends, q will store all the value of the level;
            width = end - start + 1;
            max = Math.max(max, width);
        }
        return max;
    }
    /*
    (because we have to compute the leftmost index first, and compare ALL nodes 
    distance to its level left-most node)   we use preorder traversal DFS
    
    List<Integer> lefts records the left-most index of one level.
    Compare ALL nodes distance to its level left-most node.
    */
    int max = 0;
    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, new ArrayList<Integer>(), 0, 1);
        return max;
    }
    
    void dfs(TreeNode root, List<Integer> lefts, int level, int index){
        if(root == null) return;
        if(level == lefts.size()){
           lefts.add(index); //add leftmost node
        }
        max = Math.max(max, index - lefts.get(level) + 1);//Compare ALL nodes distance to its level left-most node.
        dfs(root.left, lefts, level + 1, index * 2);
        dfs(root.right, lefts, level + 1, index * 2 + 1);
    }






}