class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<> ();
        for (int i = 0; i < s.length(); i++) {
            char value = s.charAt(i);
            if (value == '(' || value == '[' || value == '{') {
                stack.push(value);
            }
            else {// value = ')' or ']' or '}'
                if (!stack.isEmpty()) {
                    char popVal = stack.pop();
                    if ((value == ')' && popVal != '(') || 
                        (value == ']' && popVal != '[') || (value == '}' && popVal != '{')) {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
