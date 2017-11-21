class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {

    //record freq of each number
    Map<Integer, Integer> map = new HashMap<> ();//map<num, freq>
    for (int i : nums) {
        if (map.containsKey(i)) {
            map.put(i, map.get(i) + 1);
        }
        else {
            map.put(i, 1);
        }
    }

    //put them into buckets
    List<Integer>[] buckets = new List[nums.length + 1];
    for (int key : map.keySet()) {
        int frequency = map.get(key);
        if (buckets[frequency] == null) {
            buckets[frequency] = new ArrayList<>();
        }
        buckets[frequency].add(key);
    }

    List<Integer> res = new ArrayList<> ();
    for (int i = nums.length; i >= 0; i--) {
        if (buckets[i] != null) {
            for (int val : buckets[i]) res.add(val);
            if (res.size() == k) break;
        }
    }
    return res;
   }
}