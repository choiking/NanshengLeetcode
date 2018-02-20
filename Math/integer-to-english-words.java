class Solution {
    final static String[] ten = {"", "","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    final static String[] elevenToNineteen = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    final static String[] one = {"", "One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    public static String numberToWords(int num) {
        if (num == 0) return "Zero";

        int b = num / 1000000000, m = (num % 1000000000) / 1000000, t = (num % 1000000) / 1000, on = num % 1000;
        String s1 = transfer(b).equals("") ? "" : transfer(b) + " Billion ";
        String s2 = transfer(m).equals("") ? "" : transfer(m) + " Million ";
        String s3 = transfer(t).equals("") ? "" : transfer(t) + " Thousand ";
        String s4 = transfer(on);
        return (s1 + s2 + s3 + s4).trim();
    }

    static String transfer(int i) {
        String s = "";
        if (i == 0) return "";
        if (i / 100 != 0) s += one[i / 100] + " Hundred ";
        if ((i % 100) / 10 == 1) {
            s += elevenToNineteen[i % 10];
        }
        else {
            if ((i % 100) / 10 != 0) s += ten[(i % 100) / 10] + " ";
            s += one[i % 10];
        }
        return s.trim();
    }

}

//Similarily solution


public String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};//1000 2000 3000 4000
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};//100 200...900
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};//10 20...90
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};//1 2 ...9
        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    }