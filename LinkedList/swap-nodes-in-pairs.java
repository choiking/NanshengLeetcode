  public ListNode swapPairs(ListNode head) {
  //O(1) extra space
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            ListNode first = curr.next;//firstNode
            ListNode second = curr.next.next;//secondNode
            first.next = second.next;
            curr.next = second;
            curr.next.next = first;
            curr = curr.next.next;
        }

        return dummy.next;
    }



    public ListNode swapPairs(ListNode head) {
        // O (n) extra space due to stack
        if (head == null || head.next == null) {
            return head;
        }

        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }
