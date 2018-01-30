class Solution {
    /*            0   1   2   3   4
     723 * 24             4   8   12
                      14  4   6
                =     14  8   14  12
                
    */
    public static String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] digits = new int[m + n];//store 每个位数的值，比如digits[1] = 20 表示十位数是20， 即实际为200.
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                digits[i + j + 1] += d1 * d2;
            }
        }

        //calculate the actual value by invoving carry
        //when it's done digits array is the res
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int num : digits)
            sb.append(num);
        //deal with 00000 issue;
        while (sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();
    }
    //same idea with optimizelation
    public String multiply(String num1, String num2) {
    int m = num1.length(), n = num2.length();
    int[] pos = new int[m + n];
   
    for(int i = m - 1; i >= 0; i--) {
        for(int j = n - 1; j >= 0; j--) {
            int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
            int p1 = i + j, p2 = i + j + 1;
            int sum = mul + pos[p2];

            pos[p1] += sum / 10;
            pos[p2] = (sum) % 10;
        }
    }  
    
    StringBuilder sb = new StringBuilder();
    for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
    return sb.length() == 0 ? "0" : sb.toString();
}
}