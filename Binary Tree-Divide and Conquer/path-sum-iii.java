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
        return (node.val == sum ? 1 : 0) +
            PathSumFrom(node.left, sum - node.val) + PathSumFrom(node.right, sum - node.val);
    }
    /*
    从 pathSumEndWith a Node 出发解题。
    using prefix Sum idea , so we have to use HashMap
    */
    public int pathSum(TreeNode root, int sum) {
        //store <currSum, freq>
        Map<Integer, Integer> preSum = new HashMap<> ();
        preSum.put(0, 1);//for the first index
        if (root == null) return 0;
        return helper(root, 0, sum, preSum);
    }

    int helper(TreeNode root, int currSum, int sum, Map<Integer, Integer> preSum) {
        if (root == null) return 0;
        currSum += root.val;
        int res = preSum.getOrDefault(currSum - sum, 0);//to see till this end if there is
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
        res += helper(root.left, currSum, sum, preSum) + helper(root.right, currSum, sum, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);//backtracking this currSum
        return res;
    }
