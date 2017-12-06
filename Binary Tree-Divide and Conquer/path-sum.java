/*
      path sum (Root to Leaf); 
    */



      //Brute Force Solution, calculate every sum!
     public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return helper(root, sum);
    }
    int prefixSum = 0;
    boolean helper(TreeNode node, int sum) {
        if (node == null) {
            return false;
        }
        prefixSum += node.val;
        if (node.left == null && node.right == null) {//node is the leaf!!
            if (prefixSum == sum) {
                return true;
            }
            return false;
        }
        int oldVal = prefixSum;
        boolean left = helper(node.left, sum);
        prefixSum = oldVal;//reset the value, or just add it to the argument(node, sum, prefixSum);
        boolean right = helper(node.right, sum);
        return left || right;
    }
/*
   better sum - node.val = node.val
*/

    public boolean hasPathSum(TreeNode root, int sum) {
       if(root == null){
         return false;
       }
       if(root.left == null && root.right == null){
          return (root.val == sum);
       }
       return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
       
}