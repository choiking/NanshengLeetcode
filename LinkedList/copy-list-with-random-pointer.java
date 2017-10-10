/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode> ();
        RandomListNode node = head;
        // copy all the nodes
        // 1' 2' 3' 4'
        while (node != null) {
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }
        node = head;
        //assign all pointers including random and next pointer
        // 1' -> 2'...
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        
        return map.get(head);
    }
}


 
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        copyList(head);
        copyRandom(head);
        return split(head);
    }
    //1 -> 1' -> 2 -> 2'... 
    public void copyList(RandomListNode head) {
        RandomListNode curr = head;
        while (curr != null) {
            RandomListNode copy = new RandomListNode(curr.label);
            copy.next = curr.next;
            copy.random = curr.random;
            curr.next = copy;
            curr = curr.next.next;
        }
    }
    //assign the random pointer
    public void copyRandom(RandomListNode head) {
        RandomListNode curr = head;
        while (curr != null) {
            if (curr.next.random != null && curr.random != null) {
            curr.next.random = curr.random.next;
          }
            curr = curr.next.next;
      }
  }
    //assign the next pointer and split new list from old list
    public RandomListNode split(RandomListNode head) {
        RandomListNode curr = head;
        RandomListNode res = head.next;
        while (curr != null) {
            RandomListNode temp = curr.next;
            curr.next = curr.next.next;// old list
            curr = curr.next;
            if (temp.next != null) {
               temp.next = temp.next.next;// new list
            }
        }
        return res;
    }
}