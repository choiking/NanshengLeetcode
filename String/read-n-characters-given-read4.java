/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    /*
      题意：
      给一个input stream（未知长度），读取其中的n个character（using read4 api）;


      Source: abcd efgh ijk 11
      case: n = 7
      temp[abcd] count = 4, min(4, 7 - 0) = 4 buf{abcd} index = 4
      temp[efgh] count = 4, min(4, 7 - 4) = 3 buf{abcd efg} index = 7 return 7(because of index)

      Source: abcd efgh ijk 11
      case: n = 8
      temp[abcd] count = 4, min(4, 7 - 0) = 4 buf{abcd} index = 4
      temp[efgh] count = 4, min(4, 7 - 4) = 4 buf{abcd efgh} index = 8 return 8(because of index)


      Source: abcd ef 6
      case: n = 7
      temp[abcd] count = 4, min(4, 7 - 0) = 4 buf{abcd} index = 4
      temp[ef] count = 2, min(2, 7 - 4) = 2 buf{abcd ef} index = 6 return 6 (because of count)
    */
    public int read(char[] buf, int n) {
        //make an empty of temp
        char[] temp = new char[4];
        int index = 0;
        while (true) {
            //read 4 chars from source
            int count = read4(temp);
            //calculate remain chars we can read from char
            count = Math.min(count, n - index);
            //copy value from temp into buf
            for (int i = 0; i < count; i++) {
                buf[index++] = temp[i];
            }
            if (index == n || count < 4) return index;
        }
    }
}
