/*
  version 1: space: n; time n;
  always create new node DFS
*/


public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        TreeNode newNode = new TreeNode(t1 == null ? 0 : t1.val + t2 == null ? 0 : t2.val);
        t1.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        t1.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return newNode;
}

/*
  version 2: space: height(stack) 那只要递归就至少（理论上）会有space 递归层的复杂度or 1; time n;
  without creating new node DFS
*/

public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null) return null;
        if (t2 == null) return t1;
        if (t1 == null) return t2;

        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;
}