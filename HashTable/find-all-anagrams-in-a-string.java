//  cbaebabacd
//  |abc|   sliding window..
class Solution {
    public boolean compare(char[] countP, char[] countWin) {
        for (int i = 0; i < 26; i++) {
            if (countP[i] != countWin[i]) return false;
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) { 
           List<Integer> res = new ArrayList<> ();
           int m = s.length(), n = p.length();
           if (m == 0 || n > m) return res;
           char [] countP = new char[26];
           char [] countWin = new char[26];// sliding windows containing the values count
           for (int i = 0; i < n; i++) {
               countP[p.charAt(i) - 'a']++;
               countWin[s.charAt(i) - 'a']++;
           }
        
           for (int i = n; i < m; i++) {
               if (compare(countP, countWin)) {
                   res.add(i - n);
               }
               countWin[s.charAt(i) - 'a']++;// add current node(i) to window
               countWin[s.charAt(i - n) - 'a']--;// delete old first node from window
           }
           if (compare(countP, countWin)) {
                   res.add(m - n);
               }
        return res;
    }
}