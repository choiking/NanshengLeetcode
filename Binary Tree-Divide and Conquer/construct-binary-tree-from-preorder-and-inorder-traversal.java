/*
The basic idea is here:
关键是确定根，然后在inorder array找根的位置
Say we have 2 arrays, PRE and IN.
Preorder traversing implies that PRE[0] is the root node.
Then we can find this PRE[0] in IN, say it's IN[5].
Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side,
(so we know the length of left side) IN[6] to the end is on the right side.
Recursively doing this on subarrays, we can build a tree out of it :)
*/

public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;
        return buildTree(0, 0, inorder.length - 1, preorder, inorder);
    }

TreeNode buildTree(int rootPos, int inStart, int inEnd, int[] preorder, int[] inorder) {
    if (rootPos > preorder.length - 1 || inStart > inEnd) {
        return null;
    }
    TreeNode root = new TreeNode(preorder[rootPos]);
    int index = 0;//current root in inorder array
    for (int i = inStart; i <= inEnd; i++) {
        if (inorder[i] == root.val) {
            index = i;
            break;
        }
    }
    root.left = buildTree(rootPos + 1, inStart, index - 1, preorder, inorder);
    root.right = buildTree(rootPos + index - inStart + 1, index + 1, inEnd, preorder, inorder);
    //index - inStart is the size of left tree
    return root;
}
/*
The idea is as follows:

1.Keep pushing the nodes from the preorder into a stack (and keep making the tree by adding nodes to the left of the previous node) until the top of the stack matches the inorder.

2.At this point, pop the top of the stack until the top does not equal inorder (keep a flag to note that you have made a pop).

3.Repeat 1 and 2 until preorder is empty. The key point is that whenever the flag is set, insert a node to the right and reset the flag.



*/

public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        Stack<TreeNode> s = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]), cur = root;
        //i is index for preorder, j is for inorder
        for (int i = 1, j = 0; i < preorder.length; i++) {
            if (cur.val != inorder[j]) {
                cur.left = new TreeNode(preorder[i]);
                s.push(cur);
                cur = cur.left;
            } else {
                j++;
                while (!s.empty() && s.peek().val == inorder[j]) {
                    cur = s.pop();
                    j++;
                }
                cur = cur.right = new TreeNode(preorder[i]);
            }
        }
        return root;
    }
