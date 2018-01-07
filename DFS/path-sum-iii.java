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
      这类从 root 到 leaf  之间 任意 path问题的思路：
      可以从 PathSumFrom a Node 出发解题。
      或者从 pathSumEndWith a Node 出发解题。
    */
    
    /*
    可以从 PathSumFrom a Node 出发解题。
       Typical recursive DFS.
       Space: O(n) due to recursion.
       Time: O(n^2) in worst case (no branching); O(nlogn) in best case (balanced tree).
       
       time: 2T(n/2) + ɵ(n)
       
              t(n)
       t(1/2 n)  t(1/2 n)
       
       1 ..  1 1 1 . .. 1 1.
       
    */
    public int pathSum(TreeNode root, int sum) {//each time O(1), recurse n time

        if (root == null) {
            return 0;
        }
        return PathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        
    }
    int PathSumFrom(TreeNode node, int sum) {//find all the res begining from node.Time: each O(n)
        if (node == null) {
            return 0;
        }
        // add the 3 parts 
        return (node.val == sum ? 1 : 0) +
            PathSumFrom(node.left, sum - node.val) + PathSumFrom(node.right, sum - node.val);
    }


    
    /*
    从 pathSumEndWith a Node 出发解题。time :O(n)
    
    Prefix sum is a really useful technique!
    */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return findPathSum(root, 0, sum, map);  
    }
    private int findPathSum(TreeNode curr, int prefixSum, int target, Map<Integer, Integer> map) {
        if (curr == null) {
            return 0;
        }
        // update the prefix sum by adding the current val
        prefixSum += curr.val;
        // get the number of valid path, ended by the current node
        int pathSumEndWithCurr = map.getOrDefault(prefixSum - target, 0);//先判断根节点就不用担心(preSum - sum)'s node在同一level的问题
        // update the map with the current sum, so the map is good to be passed to the next recursion
        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);//preSum, frequency of this preSum
        // add the 3 parts 
        int res = pathSumEndWithCurr + findPathSum(curr.left, prefixSum, target, map)
                                               + findPathSum(curr.right, prefixSum, target, map);
       // remove this node's value from the map, as the recursion goes from the bottom to the top, so it will remove the node in the down side
        map.put(prefixSum, map.get(prefixSum) - 1);//KEY of Backtracking.
        return res;
    }



