//most intuitive Solution


public boolean isValidBST(TreeNode root) {
    if (root == null) return true;
    if (root.left != null && findMax(root.left) >= root.val) return false;
    if (root.right != null && findMin(root.right) <= root.val) return false;
    return  isValidBST(root.left) && isValidBST(root.right);
}

int findMin(TreeNode node) {
    while (node.left != null)
        node = node.left;
    return node.val;
}

int findMax(TreeNode node) {
    while (node.right != null)
        node = node.right;
    return node.val;
}

//clever idea

//every node must be smaller than the biggest node, bigger than the smallest node
public boolean isValidBST(TreeNode root) {
    return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
}

public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
    if (root == null) return true;
    if (root.val >= maxVal || root.val <= minVal) return false;
    return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
}


//use in order Traversal


public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<> ();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            }
            else {
                root = stack.pop();
                if (pre != null && pre.val >= root.val) return false;
                pre = root;
                root = root.right;
            }
        }
        return true;
    }
