/*binary search tree题，这种顺序题 一般用 inoder traversal
          5
         / \
        3   2   - > first 6
       / \          second 3
      6   4         second 2
    */
    TreeNode first = null;
    TreeNode second = null;
    TreeNode previous = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        dfs(root);//find that two node
        //swap
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    //Really, what we are comparing is the current node and its previous node in the "in order traversal".
    public void dfs(TreeNode root) {//inorder traversal
        if (root == null) return;
        dfs(root.left);
        //do sth
        if (first == null && previous.val > root.val) {
            first = previous;
            System.out.println("first" + first.val);
        }
        if (first != null && previous.val > root.val) {//second node may change in the traversal
            second = root;
            System.out.println("second" + second.val);
        }
        previous = root;//store previous node
        //end sth
        dfs(root.right);
    }
