
/*
version 1: best way, use stringBuilder to reverse, do a try catch to handle overflow.

version 2: use % / to convert to int, and res compare to Integer.MAX_VALUE to see if it is overflow.


*/


class Solution {
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder(Integer.toString(x));
        if (sb.charAt(0) == '-') {
            sb.deleteCharAt(0).append('-');
        }
        int res = 0;
        try {
             res = Integer.parseInt(String.valueOf(sb.reverse()));
        }
        catch(Exception e) {
            return 0;
        }
        return res;
    }
}







