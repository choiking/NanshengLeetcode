class Solution {
   /*
    
   string.split("(?=[-+])");
   s.replace("", "");


    */
    public String coeff(String s) {
        if (s.length() > 1 && Character.isDigit(s.charAt(s.length() - 2))) {
            return s.replace("x", "");
        }
        return s.replace("x", "1");
    }
    public String solveEquation(String equation) {
        int xSum = 0, conSum = 0;
        String[] res = equation.split("=");
        //for the left
        for (String s : res[0].split("(?=[-+])")) {
            if (s.contains("x")) {
                xSum += Integer.parseInt(coeff(s));
            }
            else {
                conSum += Integer.parseInt(s);
            }
        }
        //for the right
        for (String s : res[1].split("(?=[-+])")) {
            if (s.contains("x")) {
                xSum -= Integer.parseInt(coeff(s));
            }
            else {
                conSum -= Integer.parseInt(s);
            }
        }
        if (xSum == 0) {
            if (conSum == 0) {
                return "Infinite solutions";
            }
            return "No solution";
        }
        return "x=" + conSum / xSum * -1;
    }
}