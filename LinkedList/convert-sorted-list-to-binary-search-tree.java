/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Be careful, there is not only one way of BST realization
//  [1,2,3,4] could be
//      3                2
//   2     4   or    1       3
// 1              null null null 4


class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return buildTree(head, null);
    }
    public TreeNode buildTree(ListNode head, ListNode tail) {
        if (head == tail) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow is the middle of list
        TreeNode root = new TreeNode(slow.val);
        root.left = buildTree(head, slow);
        root.right = buildTree(slow.next, tail);
        return root;
    }
}