/*O(n) memory
  time O(1) next() and hasNext()
  use List or Queue
*/


public class BSTIterator {

    List<TreeNode> list;//Or use Queue

    public BSTIterator(TreeNode root) {//O(N)
        list = new ArrayList<> ();
        helper(root, list);
    }

    void helper(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        helper(root.left, list);
        list.add(root);
        helper(root.right, list);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {//O(1)
        return !list.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {//O(1)
        int value = list.get(0).val;
        list.remove(0);
        return value;
    }
}



/*
  O(height) memory
  O(h) next() and O(1)hasNext()
  use List or Queue

*/

public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {//O(h)
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() { //O(h) O(1) in amortized time because O(#nodes) / #nodes
        TreeNode tmpNode = stack.pop();
        pushAll(tmpNode.right);
        return tmpNode.val;
    }

    private void pushAll(TreeNode node) {
        for (; node != null; stack.push(node), node = node.left);
    }
}

//same idea as above

public class BSTIterator {
    private final Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {// O(h)
        stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {//O(1)
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {//O(h) //O(h) O(1) in amortized time because O(#nodes) / #nodes
        TreeNode node = stack.pop();

        // Traversal cur node's right branch
        TreeNode cur = node.right;
        while (cur != null){
            stack.push(cur);
            cur = cur.left;
        }

        return node.val;
    }
}

/*https://leetcode.com/problems/binary-search-tree-iterator/discuss/52647/Nice-Comparison-(and-short-Solution)
*/
public class BSTIterator {

    private TreeNode visit;
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        visit = root;
        stack = new Stack();
    }

    public boolean hasNext() {
        return visit != null || !stack.empty();
    }

    public int next() {//O(h) O(1) in amortized time because O(#nodes) / #nodes
        while (visit != null) {
            stack.push(visit);
            visit = visit.left;
        }
        TreeNode next = stack.pop();
        visit = next.right;
        return next.val;
    }
}
