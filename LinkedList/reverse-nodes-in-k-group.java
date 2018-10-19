/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param head: a ListNode
     * @param k: An integer
     * @return: a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        //find k + 1 node
        ListNode curr = head;
        int count = 0;
        while (count < k) {
            if (curr == null) return head;
            curr = curr.next;
            count++;
        }
    // 2.reverse k node at current level 
        ListNode pre = reverseKGroup(curr, k);
        while (count > 0) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            count--;
        }
        return pre;
    }
}
