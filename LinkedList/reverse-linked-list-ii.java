/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//Given m, n satisfy the following condition:
//1 ≤ m ≤ n ≤ length of list.
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null)  return null;
        int i = 1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (i < m) {
            head = head.next;
            i++;
        }
        ListNode preM = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode;
        ListNode postN = nNode.next;
        
        while (i < n) {
            ListNode temp = postN.next;
            postN.next = nNode;
            nNode = postN;
            postN = temp;
            i++;
        }
        preM.next = nNode;
        mNode.next = postN;
        
        return dummy.next;
    }
}