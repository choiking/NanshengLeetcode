/*
use String.trim(),  character.isDigit();
USE INTEGER TO STORE VALUE


*/
//we only consider  first sequence of non-whitespace characters as our result;
    public int myAtoi(String str) {
        int index = 0, sign = 1;
        long total = 0;
        // empty string
        if (str.equals("")) return 0;
        //loop through the str, remove all the spaces
        str = str.trim();
        //handle signs
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }
        //convert num and avoid overflows
        while (index < str.length()) {
            // from this, never consider the following character
            if (!Character.isDigit(str.charAt(index))) 
                return (int) total * sign;
            total = 10 * total + str.charAt(index) - '0';
            if (sign == 1 && total > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign == -1 && (-1) * total < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            index++;
        }
        return (int)total * sign;
    }