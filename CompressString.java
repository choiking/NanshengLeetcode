public class CompressString {
 /*
  abbbc  -> abc
  */
    String reduceString(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        res.append(s.charAt(0));
        int i = 1;
        while (i < s.length() ) {
            if (s.charAt(i) != s.charAt(i - 1)){
                res.append(s.charAt(i));
            }
            i++;
        }

        return res.toString();
    }
    String reduceStringE(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == 'e') {
                res.append('e');
                while (s.charAt(++i) == 'e');
            }
            else {
                res.append(s.charAt(i));
                i++;
            }
        }
        return res.toString();
    }
    /*
    aaaaaadddvv 会变成6a3d2v
     */
    String compressString(String s) {
        if (s == null) {
            return s;
        }
        if (s.length() == 1) {
            return "1" + s;
        }
        StringBuilder res = new StringBuilder();
        int read = 0, count = 1;
        while (read < s.length()) {
            if (read == s.length() - 1 || s.charAt(read) != s.charAt(read + 1)) {
                for (char c : (count + "").toCharArray()) {
                    res.append(c);
                }
                res.append(s.charAt(read));
                count = 1;
            }
            else {
                count++;
            }
            read++;
        }
        return res.toString();
    }
    public static void main(String args[]) {
         CompressString test = new CompressString();
         System.out.println(test.reduceString("aaaabbbbceeeerefdddd"));
         System.out.println(test.reduceStringE("dddddeeeeceeevgggg"));
         System.out.println(test.compressString("ddbrgffcc"));
    }
}
