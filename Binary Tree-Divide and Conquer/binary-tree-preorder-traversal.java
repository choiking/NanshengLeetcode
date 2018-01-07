/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//version 1 DFS recursive
class Solution {
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return res;
}
}


class Solution {// version 2: Divide and Conquer
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        //Divide
        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);
        
        //Conquer
        res.add(root.val);
        res.addAll(left);
        res.addAll(right);
        return res;
}
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


 //version 3: DFS using stack
    //stack is different from queue in order because stack is FILO, queue is FIFO
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        if (root == null) return res;
        stack.push(root);
        
        while (!stack.empty()) {
            TreeNode temp = stack.pop();
            res.add(temp.val);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        return res;
    }


//Another DFS using stack(more complicatied);

    //instance of Stack is thread safe (lock/synchronize inside), so Dequeue should be faster.
//Queue: offer, poll, peek   stack: push, pop, peek 
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new LinkedList<>();
    Deque<TreeNode> stack = new LinkedList<>();
    TreeNode node = root;
    while (node != null || !stack.isEmpty()) {
        if (node != null) {
            result.add(node.val);
            stack.push(node.right);
            node = node.left;
        } else {
            node = stack.pop();
        }
    }
    return result;
}
