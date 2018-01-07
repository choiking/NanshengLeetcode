class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
         /*
        vertical scanning
        */
        int i = 0, minStrLen = Integer.MAX_VALUE;
        while (i < strs.length) {//preprocss to find min string length
            minStrLen = Math.min(minStrLen, strs[i].length());
            i++;
        }
        int j = 0;
        while (j < minStrLen) {//loop through each char
            Character item = strs[0].charAt(j);
            i = 1;
            while (i < strs.length) {//loop through all string
                if (strs[i].charAt(j) != item) {
                    return strs[0].substring(0, j);
                }
                i++;
            }
            j++;
        }
        return strs[0].substring(0, j);
        /*
        horizontal scanning
        */
        int i = 1;
        String prefix = strs[0];
        while (i < strs.length) {//loop through all string
            while (strs[i].indexOf(prefix) != 0) {//not strs[i]'s prefix
                prefix = prefix.substring(0, prefix.length() - 1);//shorter the prefix to make it fit
                if (prefix.isEmpty()) {
                    return "";
                }
            }
            i++;
        }
        return prefix;
        
    }
    /*
      DIVIDE AND CONQUER
    */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";    
            return longestCommonPrefix(strs, 0 , strs.length - 1);
        }

        private String longestCommonPrefix(String[] strs, int l, int r) {
            if (l == r) {
                return strs[l];
            }
            else {
                int mid = (l + r)/2;
                String lcpLeft =   longestCommonPrefix(strs, l , mid);
                String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
                return commonPrefix(lcpLeft, lcpRight);
           }
        }

        String commonPrefix(String left,String right) {
            int min = Math.min(left.length(), right.length());       
            for (int i = 0; i < min; i++) {
                if ( left.charAt(i) != right.charAt(i) )
                    return left.substring(0, i);
            }
            return left.substring(0, min);
        }
}