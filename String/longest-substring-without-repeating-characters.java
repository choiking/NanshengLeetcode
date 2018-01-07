class Solution {
    /*
    Stringbuilder; indexOf()
    O(n)
    */
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0, i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            Character item = s.charAt(i);
            int repeatedIndex = sb.indexOf(item + "");
            if (repeatedIndex < 0) {//not exist
                sb.append(item + "");
                maxLen = Math.max(maxLen, sb.length());
            }
            else {
                /*
                nxzmdvcg  v
                */
                maxLen = Math.max(maxLen, Math.max(repeatedIndex + 1, sb.length() - repeatedIndex));//(max, 5, 3)
    
                //skip to repead one + 1
                sb = new StringBuilder(sb.substring(repeatedIndex + 1));
                sb.append(item + "");//sb = cgv now     
            }
            i++;
        }
        return maxLen;
    }
    /*
      sliding window (i, j)
      TWO POINTER and HashSet 
      O(2n) 2 run
    */
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0, i = 0, j = 0;
        Set<Character> set = new HashSet<> ();
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                maxLen = Math.max(maxLen, j - i);
            }
            else {//remove all the elment from zero to the repeated one
                set.remove(s.charAt(i++));
            }
        }
        
        return maxLen;
    }
    /*
      sliding window (i, j)
      TWO POINTER and HashMap  record the index of every character
      O(n)
    */
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0, i = 0, j = 0;
        Map<Character, Integer> map = new HashMap<> ();//current index of Character
        while (j < s.length()) {
            Character item = s.charAt(j);
            if (map.containsKey(item)) {
                /*
                    i j
                a b b a
                */
                i = Math.max(map.get(item) + 1, i);
            }
            map.put(item, j);
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        
        return maxLen;
    }
    
    /*
      sliding window (i, j)
      TWO POINTER and Charset  record the index of every character
      O(n)
      
      int[26] for Letters 'a' - 'z' or 'A' - 'Z'
      int[128] for ASCII
      int[256] for Extended ASCII
    */
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0, i = 0, j = 0;
        int index[] = new int[128];//current index of Character
        while (j < s.length()) {
            Character item = s.charAt(j);
            /*
                    i j
                a b b a
            */
            i = Math.max(index[item], i);
            index[item] = j + 1;
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        
        return maxLen;
    }
}