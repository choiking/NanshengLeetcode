class Solution {
    /*
    most intuitive Brute Force 
    Note that k is guaranteed to be a positive integer.
    when it is number, it must be followd by [..]
     */
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int times = 0;
        for (int i = 0; i < s.length(); i++) {
            char value = s.charAt(i);
            if (Character.isDigit(value)) {
                times = times * 10 + (value - '0');
            }
            else if (value == '[') {
                int begin = i + 1;
                i++;
                int count = 1;
                while (count != 0) {//find  ]
                    if (s.charAt(i) == '[') count++;
                    else if (s.charAt(i) == ']') count--;
                    i++;
                }
                String encodedStr = decodeString(s.substring(begin, i - 1));
                for (int index = 0; index < times; index++) {
                    res.append(encodedStr);
                }
                
                //back to default value
                i--;
                times = 0;
            }
            else {//it must be a letter
                res.append(value);
            }
        }

        return res.toString();
    }
    /*
      使用stack 可以模拟 recursive
    */
    public String decodeString(String s) {
        StringBuilder cur = new StringBuilder();
        Stack<StringBuilder> letter = new Stack<> ();
        Stack<Integer> times = new Stack<> ();
        int time = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {//record time
                time = time * 10 + c - '0';
            }
            else if (c == '[') {
                times.push(time);//add former time
                letter.push(cur);//add former cur
                cur = new StringBuilder();
                time = 0;
            }
            else if (c == ']') {//add to res
                StringBuilder encodeStr = cur;
                cur = letter.pop();
                for (int idx = times.pop(); idx > 0; idx--) cur.append(encodeStr);
            }
            else {
                cur.append(c);
            }
        }   
        return cur.toString();
    }
    
    
}