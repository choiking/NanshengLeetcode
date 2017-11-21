/*
  version 1: use Map<Char, freq> to store frequency of each Character.
  version 2: map + priority Queue (same as Heap in Java), pq can save sorting time
  version 3 and 4: Bucket Sort

*/
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<> ();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) map.put(c, 1);
            else map.put(c, map.get(c) + 1);
        }
        Object[] objectArray = map.values().toArray();
        List<Integer> freq = new ArrayList<>();
        for (Object obj : objectArray) {
            freq.add((int)obj);
        }
        Collections.sort(freq);//O(n*log(n)) n is the size of freq
        List<Integer> freqWithoutDup = freq.stream().distinct().collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (int i = freqWithoutDup.size() - 1; i >= 0; i--) {
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue().equals(freqWithoutDup.get(i))) {
                    char val = entry.getKey();
                    int count = entry.getValue();
                    while (count > 0) {
                        sb.append(val);
                        count--;
                    }
                }
            }
        }
        return sb.toString();
    }
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<> ();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) map.put(c, 1);
            else map.put(c, map.get(c) + 1);
        }
        Object[] objectArray = map.values().toArray();
        PriorityQueue<Integer> freq = new PriorityQueue<>();
        for (Object obj : objectArray) {
            freq.add((int)obj);//O(logn)
        }
        List<Integer> freqWithoutDup = new ArrayList<>();
        while (!freq.isEmpty()) {
            int val = freq.remove();O(logn)
            if (!freqWithoutDup.contains(val))
            freqWithoutDup.add(val);
        }//total O(n*logn)
        StringBuilder sb = new StringBuilder();
        for (int i = freqWithoutDup.size() - 1; i >= 0; i--) {
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue().equals(freqWithoutDup.get(i))) {
                    char val = entry.getKey();
                    int count = entry.getValue();
                    while (count > 0) {
                        sb.append(val);
                        count--;
                    }
                }
            }
        }
        return sb.toString();
    }
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        //put them into buckets
        List<Character> [] bucket = new List[s.length() + 1];//freq must < s.length();
        for (char key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        StringBuilder sb = new StringBuilder();
        for (int pos = bucket.length - 1; pos >=0; pos--) {
            if (bucket[pos] != null) {
                for (char num : bucket[pos]) {
                    for (int i = 0; i < map.get(num); i++) {
                        sb.append(num);
                    }
                }
            }
        }
        return sb.toString();
    }
    
    public String frequencySort(String s) {
        if(s.length() < 3)
            return s;
        int max = 0;
        int[] map = new int[256];
        for(char ch : s.toCharArray()) {
            map[ch]++;
            max = Math.max(max,map[ch]);
        }
        //use int array to replace Map<Character, Integer>
        String[] buckets = new String[max + 1]; // create max buckets(use max to save Space(instead of using s.length))
        for(int i = 0 ; i < 256; i++) { // join chars in the same bucket
            String str = buckets[map[i]];
            if(map[i] > 0)
                buckets[map[i]] = (str == null) ? "" + (char)i : (str + (char) i);
        }
        StringBuilder strb = new StringBuilder();
        for(int i = max; i >= 0; i--) { // create string for each bucket.
            if(buckets[i] != null)
                for(char ch : buckets[i].toCharArray())
                    for(int j = 0; j < i; j++)
                        strb.append(ch);
        }
        return strb.toString();
    }
}