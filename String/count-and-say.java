class Solution {
    /*
    "Count and Say problem" Write a code to do following: 
    n String to print 
    0 1 
    1 1 1 
    2 2 1 
    3 1 2 1 1 
    ... 
    Base case: n = 0 print "1" 
    for n = 1, look at previous string and write number of times a digit is seen and 
    the digit itself. In this case, digit 1 is seen 1 time in a row... so print "1 1"
    for n = 2, digit 1 is seen two times in a row, so print "2 1" 
    for n = 3, digit 2 is seen 1 time and then digit 1 is seen 1 so print "1 2 1 1" 
    for n = 4 you will print "1 1 1 2 2 1" 

    Consider the numbers as integers for simplicity. e.g. if previous string is "10 1" 
    then the next will be "1 10 1 1" and the next one will be "1 1 1 10 2 1"
    */
   // public String countAndSay(int n) {
   //      int count;
   //      String curr = "1";
   //      StringBuilder sb = new StringBuilder();
   //      String preStr = "";
   //      char say;
   //      for (int i = 1; i < n; i++) {
   //          count = 1;
   //          preStr = curr;
   //          say = preStr.charAt(0);
   //          for (int j = 0; j < preStr.length() - 1; j++) {
   //              if (preStr.charAt(j) != preStr.charAt(j + 1)) {
   //                  sb.append(count + say + "");
   //                  say = preStr.charAt(j + 1);
   //                  count = 1;
   //              }
   //              else {
   //                  count++;
   //              }
   //          }
   //          sb.append(count + say.toString());//the last element
   //          res[i] = sb.toString();
   //      }
   //      return res[n - 1];
   //  }
    
    
    public String countAndSay(int n) {
        int count;
        StringBuilder curr = new StringBuilder("1");
        StringBuilder preStr;
        char say;
        for (int i = 1; i < n; i++) {
            count = 1;
            preStr = curr;
            curr = new StringBuilder();
            say = preStr.charAt(0);

            for (int j = 0; j < preStr.length() - 1; j++) {
                if (preStr.charAt(j) != preStr.charAt(j + 1)) {
                    curr.append(count).append(say);
                    say = preStr.charAt(j + 1);
                    count = 1;
                }
                else {
                    count++;
                }
            }
            curr.append(count).append(say);//the last element
        }
        return curr.toString();
    }
}