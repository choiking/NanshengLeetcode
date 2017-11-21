class Solution {
    public boolean isValid(String s) {
        
        if (s == null) return false;
        Stack<Character> stack = new Stack<Character>();
        char[] ch = s.toCharArray();
        
        for (int i = 0; i < ch.length; i++) {
            
            if (ch[i] == '(' || ch[i] == '{' || ch[i] == '[') {
            stack.push(ch[i]);
            }
            
            else if (ch[i] == ')' || ch[i] == '}' || ch[i] == ']') {
                if (stack.empty() || ((ch[i] == ')' && stack.peek() != '(') || 
                    (ch[i] == '}' && stack.peek() != '{') || (ch[i] == ']' && stack.peek() != '['))) {
                    return false;
                }
                 else {
                     stack.pop();
                 }
            }
                 
    }
        return stack.empty();
}
}