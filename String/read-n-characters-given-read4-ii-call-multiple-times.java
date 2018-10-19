/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

/*
https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multip
le-times/discuss/49598/A-simple-Java-code

abcdef

read5()  

when read5 done, buffPointer = 1, buffCounter = 2; buff = {ef}, f还没被读取
read2()




*/
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read

     used buffer pointer (buffPtr) and buffer Counter (buffCnt) to store the data received in previous calls.

     */
    private int buffPointer = 0;
    private int buffCounter = 0;
    private char[] buff = new char[4];//store the temporary value read4 read

    public int read(char[] buf, int n) {
        int pointer = 0;
        while (pointer < n) {
            if (buffPointer == 0) {
                buffCounter = read4(buff);
            }
            if (buffCounter == 0) break;//finish
            while (pointer < n && buffPointer < buffCounter) {
                buf[pointer++] = buff[buffPointer++];
            }
            if (buffPointer == buffCounter) {//finish reading all value of buff array, reset buffPointer
                buffPointer = 0;
            }
        }
        return pointer;//The number of characters read
    }
}
