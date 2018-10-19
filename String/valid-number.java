/*
https://leetcode.com/problems/valid-number/discuss/23738/Clear-Java-solution-with-ifs

We start with trimming.

1 If we see [0-9] we reset the number flags
2 We can only see . if we didn't see e or .
3 We can only see e if we didn't see e but we did see a number. We reset numberAfterE flag
4 We can only see + and - in the beginning and after an e
5 any other character break the validation


At the and it is only valid if there was at least 1 number and if we did see an e
then a number after it as well.


*/



public boolean isNumber(String s) {
        s = s.trim();
        boolean numberSeen = false;
        boolean eSeen = false;
        boolean pointSeen = false;
        boolean numberAfterE = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if (c == '.') {
                //2e.2    3.2.1
                if (eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if (c == 'e' || c == 'E') {
              //no double e, e cannot be head
                if (eSeen || !numberSeen) {
                    return false;
                }
                eSeen = true;
                numberAfterE = false;//2e
            } else if (c == '+' || c == '-') {
                //sign can only show after e, or at the head
                if (i != 0 && s.charAt(i-1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numberSeen && numberAfterE;
    }
