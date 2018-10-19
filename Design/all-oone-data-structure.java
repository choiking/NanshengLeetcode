//https://leetcode.com/problems/all-oone-data-structure/discuss/135377/Java-simple-solution%252525253A-Double-linked-List%252525252BHashMap/180314
//doubly Linked List(for most getMax, getMin problem) + HashMap
class AllOne {
    private class Node {
        public String key;
        public int val;
        public Node next;
        public Node pre;

        public Node(String key, int val) {
            this.key = key;
            this.val = val;
        }
	}

  //always keep the list sorted
  private Node dumpHead;
	private Node tail;
	private final Map<String, Node> nodeMap;

    /** Initialize your data structure here. */
    public AllOne() {
        dumpHead = new Node(null, -1);
        tail = dumpHead.next;
        nodeMap = new HashMap<> ();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        Node p;
        if (nodeMap.containsKey(key)) {
            p = nodeMap.get(key);
            p.val++;
            //average O(1),因为当排好序的时候只用swap一次，除非worst case  2 - 1 - 1 - 1 - 1 - 1
            while (p.next != null && p.val > p.next.val)// keep swap p with p.next to keep the list sorted
                swapForward(p);
        } else {// insert between dumpHead and dumpHead.next, since it val 1 is minimum
            p = new Node(key, 1);
            p.next = dumpHead.next;
            if (dumpHead.next != null)
                dumpHead.next.pre = p;
            dumpHead.next = p;
            p.pre = dumpHead;
            nodeMap.put(key, p);
        }
        if (p.next == null)
            tail = p;
    }

    private void swapForward(Node p) {//swap p with p.next
        Node nextNode = p.next, preNode = p.pre;

        p.pre = nextNode;
        preNode.next = nextNode;
        nextNode.pre = preNode;
        p.next = nextNode.next;

        if (nextNode.next != null)
            nextNode.next.pre = p;
        nextNode.next = p;
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        Node p;
        if (nodeMap.containsKey(key)) {
            p = nodeMap.get(key);
            p.val--;
            while (p.pre != dumpHead && p.val < p.pre.val) {
                if (tail == p)
                    tail = p.pre;
                swapBackward(p);
            }
            if (p.val == 0) {//this node must be head
                nodeMap.remove(key);
                dumpHead.next = p.next;
                if (p.next != null)
                    p.next.pre = dumpHead;
                p.pre = null;
                p.next = null;
            }
        }
    }

    private void swapBackward(Node p) {
        Node preNode = p.pre, ppNode = preNode.pre;

        preNode.pre = p;
        ppNode.next = p;
        p.pre = ppNode;
        preNode.next = p.next;
        if (p.next != null) {
            p.next.pre = preNode;
        }
        p.next = preNode;
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (tail == null)
            return "";
        return tail.key;
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (dumpHead.next == null)
            return "";
        return dumpHead.next.key;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
