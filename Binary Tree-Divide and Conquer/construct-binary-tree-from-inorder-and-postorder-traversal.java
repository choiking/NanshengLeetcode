//locate the root of postorder(which is the last one), then find it in the inorder array
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        Map<Integer, Integer> indexes = new HashMap();
        for(int i =0; i<inorder.length; i++){
            indexes.put(inorder[i],i);
        }
        return buildTree(postorder.length - 1, 0, inorder.length - 1, inorder, postorder, indexes);
    }

    TreeNode buildTree(int postStart, int inStart, int inEnd, int[] inorder, int[] postorder, Map<Integer, Integer> indexes) {
        if (inStart > inEnd || postStart < 0) return null;
        TreeNode root = new TreeNode(postorder[postStart]);
        int index = indexes.get(root.val);
        //inEnd - index is the length of right leaf
        root.left = buildTree(postStart - (inEnd - index) - 1, inStart, index - 1, inorder, postorder, indexes);
        root.right = buildTree(postStart - 1, index + 1, inEnd, inorder, postorder, indexes);
        return root;
    }
