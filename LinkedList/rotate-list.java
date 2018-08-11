//The basic idea is to link the tail of the list with the head, make it a cycle. Then count to the rotate point and cut it.
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        ListNode node = head;
        int len = 1;
        while (node.next != null) {
            len++;
            node = node.next;
        }
        //now node is the tail
        //link the tail with the head
        node.next = head;
        //count to the rotate point
        for (int i = 1; i < len - k % len; i++) {
            head = head.next;
        }
        node = head.next;//new head;
        head.next = null;//cut it

        return node;

    }
