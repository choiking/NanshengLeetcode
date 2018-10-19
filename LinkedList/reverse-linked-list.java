/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  //itervative solution
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        // we need prev and nextTemp to store the prev in order to point to it.
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}

//recursive 

public ListNode reverseList(ListNode head) {
      if (head == null || head.next == null) return head;
      ListNode p = reverseList(head.next);
      head.next.next = head;
      head.next = null;

      return p;

  }
