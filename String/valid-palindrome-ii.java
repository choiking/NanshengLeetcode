class Solution {
    public boolean validPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        boolean a = false, b = false;
        int i = 0, j = s.length() - 1;
        while (i + 1 < j) {
            if (sb.charAt(i) != sb.charAt(j)) {
                if (sb.charAt(i) == sb.charAt(j - 1)) {
                    a = compareReverse(sb.substring(i, j).toString());
                }
                if (sb.charAt(i + 1) == sb.charAt(j)) {
                    b = compareReverse(sb.substring(i + 1, j + 1).toString());
                }
                if (a || b) return true;
                else return false;
            }
            i++;
            j--;
        }

        return true;
    }
    private boolean compareReverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        StringBuilder old = new StringBuilder(sb);
        //StringBuilder inherits equals() from java.lang.Object, and as
        // such StringBuilder.equals() returns true only when passed the
        // same object as an argument. It does not compare the contents!
        if (old.toString().equals(sb.reverse().toString())) return true;
        else return false;
    }







    public boolean validPalindrome(String s) {
    int l = -1, r = s.length();
    while (++l < --r) 
        if (s.charAt(l) != s.charAt(r)) return isPalindromic(s, l, r+1) || isPalindromic(s, l-1, r);
    return true;
}

    public boolean isPalindromic(String s, int l, int r) {
        while (++l < --r) 
            if (s.charAt(l) != s.charAt(r)) return false;
        return true;
    }
}