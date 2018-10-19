/*
  inserting then between pre and pre.next. You keep moving then forward by 1 until
  you reach the difference, m - n, & you keep making start.next point to then.next to
  insure it's always pointing to the tail part of the list. Pretty simple lol.
    */
public ListNode reverseBetween(ListNode head, int m, int n) {
    if (head == null) return null;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy;
    for (int i = 0; i < m - 1; i++) pre = pre.next;

    ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
    ListNode then = start.next; // a pointer to a node that will be reversed

    // 1 - 2 -3 - 4 - 5 ; m = 2; n = 4 ---> pre = 1, start = 2, then = 3
    // dummy-> 1 -> 2 -> 3 -> 4 -> 5

    //inserting then between pre and pre.next
    for (int i = 0; i < n - m; i++) {
        start.next = then.next;
        then.next = pre.next;
        pre.next = then;
        then = start.next;
    }

    return dummy.next;
}
//Given m, n satisfy the following condition:
//1 ≤ m ≤ n ≤ length of list.
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
      if (head == null)  return null;
      int i = 1;
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      ListNode preM = dummy;
      while (i < m) {
          preM = preM.next;
          i++;
      }
      ListNode mNode = preM.next;
      ListNode nNode = mNode;
      ListNode postN = nNode.next;

      while (i < n) {
          ListNode temp = postN.next;
          postN.next = nNode;//connect back

          nNode = postN;//moving right
          postN = temp;//moving right
          i++;
      }
      preM.next = nNode;
      mNode.next = postN;

      return dummy.next;
    }
}
