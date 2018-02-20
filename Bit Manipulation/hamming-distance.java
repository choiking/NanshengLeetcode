
public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
}



public int hammingDistance(int x, int y) {
    int xor = x ^ y, count = 0;//相同为0， 不同为1
    for (int i = 0; i < 32; i++) count += (xor >> i) & 1;//找有多少个1
    return count;
}

/*
      本质上就是找在相应位置一共有几个不同的点
    */

public int hammingDistance(int x, int y) {
        String s1 = Integer.toBinaryString(x), s2 = Integer.toBinaryString(y);
        int count = 0, m = s1.length(), n = s2.length();
        
        int gap = Math.abs(m - n);
        if (m > n) {
            while (gap > 0) {
                s2 = "0" + s2;
                gap--;
            }
        }
        else {
            while (gap > 0) {
                s1 = "0" + s1;
                gap--;
            }
        }
        
        for (int i = 0; i < Math.max(m, n); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }
        return count;
    }


