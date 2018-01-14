class Solution {
    /*         i j
           h e l l o
    */
    //16ms
    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
              if (j == needle.length()) return i;
              if (i + j == haystack.length()) return -1;
              if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
    //6ms
      public int strStr(String haystack, String needle) {
          int l1 = haystack.length(), l2 = needle.length();
          
          for (int i = 0; i <= l1 - l2; i++) {
              if (haystack.substring(i, i + l2).equals(needle)) {
                  return i;
              }
          }
          return -1;
      }
    
    //7ms return haystack.indexOf(needle);
}