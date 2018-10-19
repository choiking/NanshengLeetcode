//USING Stack
public int calculate(String s) {
        Stack<Integer> stack = new Stack<> ();
        char sign = '+';
        String num = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num += String.valueOf(c);
            }
            //remember to take care the last num, so we use if if
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                int value = Integer.parseInt(num);
                switch(sign) {
                    case '+':
                        stack.push(value);
                        break;
                    case '-':
                        stack.push(-1 * value);
                        break;
                    case '*':
                        stack.push(stack.pop() * value);
                        break;
                    case '/':
                        stack.push(stack.pop() / value);
                        break;
                }
                num = "";
                sign = c;
            }
        }
        int res = 0;
        for (int i : stack)
            res += i;

        return res;
    }
//without using stack

public int calculate(String s) {
        int res = 0;
        char sign = '+';
        for (int i = 0, num = 0, pre = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (int)(c - '0');
            }
            if ("+-*/".indexOf(c) >= 0 || i == s.length() - 1) {
                if (sign == '+') {
                    pre = num;
                } else if (sign == '-') {
                    pre = -num;
                } else if (sign == '*') {
                    res -= pre;
                    pre *= num;
                } else {
                    res -= pre;
                    pre /= num;
                }
                sign = c;
                num = 0;
                res += pre;
            }
        }

        return res;
    }
