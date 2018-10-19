public ListNode removeNthFromEnd(ListNode head, int n) {
  //two pass
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        int len = 0;
        while (curr != null) {
            curr = curr.next;
            len++;
        }
        //find the node before Nth
        curr = dummy;
        for (int i = 0; i < len - n; i++) {
            curr = curr.next;
        }
        //do remove
        curr.next = curr.next.next;
        return dummy.next;
    }

/*
one pass
想象一下，两个人进行 100m 赛跑，假设他们的速度相同。开始的时候，第一个人就在第二个人前边 10m ，
这样当第一个人跑到终点的时候，第二个人相距第一个人依旧是 10m ，也就是离终点 10m。

对比于链表，我们设定两个指针，先让第一个指针遍历 n 步，然后再让它俩同时开始遍历，这样的话，
当第一个指针到头的时候，第二个指针就离第一个指针有 n 的距离，所以第二个指针的位置就刚好是倒数第 n 个结点。
*/
public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode first = dummy;
    ListNode second = dummy;
    //第一个指针先移动 n 步
    for (int i = 1; i <= n + 1; i++) {
        first = first.next;
    }
    //第一个指针到达终点停止遍历
    while (first != null) {
        first = first.next;
        second = second.next;
    }
    second.next = second.next.next;
    return dummy.next;
}
