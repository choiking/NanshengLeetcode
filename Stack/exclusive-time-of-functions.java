class Solution {
    /*
    brute force 
    */
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<> ();//only store function id
        String[] s;
        int time = 0;
        for (int i = 0; i < logs.size(); i++) {
            s = logs.get(i).split(":");
            if (!stack.isEmpty()) {
                while (time < Integer.parseInt(s[2])) {
                    res[stack.peek()]++;
                    time++;
                }
            }
            if (s[1].equals("start")) {
                stack.push(Integer.parseInt(s[0]));
            }
            else {//item[1].equals("end")
                res[stack.peek()]++;
                time++;
                stack.pop();
            }
        }
        return res;
    }
    
    /*
    brute force Optimatize
    */
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<> ();//only store function id
        String[] s = logs.get(0).split(":");
        stack.push(Integer.parseInt(s[0]));
        int prevTime = 0;
        for (int i = 0; i < logs.size(); i++) {
            s = logs.get(i).split(":");
            if (s[1].equals("start")) {
                if (!stack.isEmpty())
                    res[stack.peek()] += Integer.parseInt(s[2]) - prevTime;
                prevTime = Integer.parseInt(s[2]);
                stack.push(Integer.parseInt(s[0]));
            }
            else {//item[1].equals("end")
                res[stack.peek()] += Integer.parseInt(s[2]) - prevTime + 1;
                prevTime = Integer.parseInt(s[2]) + 1;
                stack.pop();
            }
        }
        return res;
    }
}