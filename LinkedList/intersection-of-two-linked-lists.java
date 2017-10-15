/*
verison 1:
use hashMap to store reference in A, if A containsKey of B, return the node;

version 2:
use two pointer do two iteration
we let a be headA, b be headB, when a reachs end, redirect it be headB, the same as B,
because the run the same length

*/



public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode, Integer> map = new HashMap<> ();
        while (headA != null) {
            map.put(headA, 1);
            headA = headA.next;
        }
        while (headB != null) {
            if (map.containsKey(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }
}


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}