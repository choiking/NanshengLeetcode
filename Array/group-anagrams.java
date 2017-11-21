/*
   Version 1:
   
   res = { "aer" : ["are", "ear"],
           "abt" : ["bat", "tab"],
           "ecdo": ["code"]
   }
   
   we can know if strings are anagrams by sorting result
   maintain a Map<sorted String, Strings in strs>

   Time complexity: O(NKlog(K)), where N is the length of strs, and K is 
   the maximum length of a string in strs. The outer loop has complexity O(N)
   as we iterate through each string. Then, we sort each string in O(KlogK) time.
   
   Version 2:
   
   res = { "#2#1#0#0.." : ["aab", "aba", "baa"],
           "#1#2#3#0.." : ["abbccc"]
   }
   
   
   Time Complexity: O(N∗K), where N is the length of strs, and K is the maximum 
   length of a string in strs. Counting each string is linear in the size of the 
   string, and we count every string.

   Space Complexity: O(N∗K), the total information content stored in ans.
   
   
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<> ();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);//O(KlogK) 
            String key = String.valueOf(ca);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<> ());
            }
            map.get(key).add(s);
        }

        return new ArrayList<> (map.values());//map.values() return Collections of map's values
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;
            
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}