class Solution {
    /*
    using MaxHeap(priority queue implementation, ..refer to priority queue doc)
    "public PriorityQueue(int initialCapacity,
             Comparator<? super E> comparator)"
    String.compareTo(another string)  "Compares two strings lexicographically. " 
    
    The size of the priority queue is k. Each insertion takes logk time and we are iterating 
    over n distinct words in the worst case and inserting them into the priority queue which 
    makes the total runtime nlogk.
    
    
    
    "e1.getKey().compareTo(e2.getKey())" in alphabetic order
    "e2.getValue() - e1.getValue()"  change to Max Heap
    */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freMap = new HashMap<> ();
        for (String s : words) {
            if (freMap.containsKey(s)) {
                freMap.put(s, freMap.get(s) + 1);
            }
            else {
                freMap.put(s, 1);
            }
        }
        // change priority queue default Min Heap to Max Heap
       PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<> (k, 
       (e1, e2) -> e1.getValue() == e2.getValue() ? e1.getKey().compareTo(e2.getKey()) : e2.getValue() - e1.getValue());
        for (Map.Entry<String, Integer> map : freMap.entrySet()) {
            maxHeap.add(map);//each insert require logK time
        }
        List<String> res = new ArrayList<> ();
        while (res.size() < k) {
            res.add(maxHeap.poll().getKey());
        }
        return res;
    }
}