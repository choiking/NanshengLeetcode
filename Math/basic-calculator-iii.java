class Solution {
    /*
    https://leetcode.com/problems/basic-calculator-iii/discuss/113600/Java-O(n)-Solution-Using-Two-Stacks
    O(n) solution using two stacks

    example: 1 - (2 + 3) * 4 - 5
            num: 1(remove) 2(remove) 3(remove) 5(remove) 4(remove) 20(remove) -19 5    -19  -  5   = -24
            ops: -(remove) ((remove) +(remove) *(remove) -

    */
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> nums = new Stack<> ();
        Stack<Character> ops = new Stack<> ();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                num = c - '0';
                //iteratively calculate each number
                while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                nums.push(num);
                num = 0;
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                // do the math when we encounter a ')' until '('
                while (ops.peek() != '(')
                    nums.push(operation(ops.pop(), nums.pop(), nums.pop()));
                ops.pop(); // get rid of '(' in the ops stack
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!ops.isEmpty() && precedence(c, ops.peek()))
                    nums.push(operation(ops.pop(), nums.pop(), nums.pop()));
                ops.push(c);
            }
        }
        while (!ops.isEmpty()) {
            System.out.println(ops.peek() + " ops");
            System.out.println(nums.peek() + " nums");
            nums.push(operation(ops.pop(), nums.pop(), nums.pop()));
        }
        return nums.pop();
    }

    private static int operation(char op, int b, int a) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b; // assume b is not 0
        }
        return 0;
    }

    // helper function to check precedence of current operator and the uppermost operator in the ops stack
    private static boolean precedence(char currOp, char preOp) {//优先级
        //return true if preOp 优先于 currOp
        if (preOp == '(' || preOp == ')') return false;
        if ((currOp == '*' || currOp == '/') && (preOp == '+' || preOp == '-')) return false;
        return true;
    }

}
