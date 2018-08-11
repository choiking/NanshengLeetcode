public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<> ();
        if (root == null) return res;
        List<Integer> list = new ArrayList<> ();
        dfs(root, res, list, sum);
        return res;
    }
    void dfs(TreeNode root, List<List<Integer>> res, List<Integer> list, int sum) {
        if (root == null) return;
        //leaf node
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                res.add(new ArrayList<> (list));
            }
        }
        dfs(root.left, res, list, sum - root.val);
        dfs(root.right, res, list, sum - root.val);
        list.remove(list.size() - 1);//backtracking
    }

    
