class Solution {
    //running time O(2n), left and right each pass the S, space time O(1);
    public String minWindow(String s, String t) {
        if (s == "" || t == "" || t.length() > s.length()) return "";
        
        int[] tMap = new int[256];
        for (char c : t.toCharArray()) {
            tMap[c]++;//create a tMap containing all the char in String t.
        }
        
        int counter = t.length(), left = 0, right = 0, from = 0, min = Integer.MAX_VALUE;
        while (right < s.length()) {//moving right point
            if (tMap[s.charAt(right)] > 0) {
                counter--;//if tMap contains that char, delete counter by one;
            }
            tMap[s.charAt(right)]--;//if tMap doesn't contains that char, it will become -1, else become 0
            
            while (counter == 0) {//means it is a valid window(moving left point)
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    from = left;
                }
                //because we have preprocess it by moving right
                //(if tMap doesn't contains that char, it will become -1, else become 0), 
                //so if it contains, after ++, it will become 1, else become 0;
                if (++tMap[s.charAt(left)] > 0) {
                    counter++;//break
                }    
                left++;
            }
            right++;
        } 
        
        return (min == Integer.MAX_VALUE) ? "" : s.substring(from, from + min);
    }
}