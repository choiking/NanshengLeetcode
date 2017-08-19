public class Solution {
    public void reverseWords(char[] s) {
        //3 step
        //reverse the whole string
        reverse(s, 0, s.length - 1);
        //reverse each word
        int start = 0;
        for(int i = 0; i < s.length; i++) {
            if(s[i] == ' ') {
                reverse(s, start, i -1);
                start = i + 1;
            }
        }
        //reverse the last word. this will solve the corner case( only one word);
        reverse(s, start, s.length - 1);
    }
    
    public void reverse(char[] s, int start, int end) {
    while (start < end) {
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        start++;
        end--;
    }
    }
}