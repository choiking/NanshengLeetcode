class Solution {
    /*
     the key is always make sure that task with highest count put in the first of CYCLE.
     {A 4, B 3, C 2, D 2, F 2, G 1}
     |A B C| A B D | A F B| A F D| C G
    */
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }
        Arrays.sort(count);
        int intervals = 0;
        while (count[25] > 0) {
            int i = 0;
            while (i <= n) {//this is for each n (there are n + 1 intervals in a cycle) cycle
                if (count[25] == 0) {//task with highest count is finish, break;
                    break;
                }
                if (i < 26 && count[25 - i] > 0) {
                    count[25 - i]--;//always schedule the task with highest count first;
                }
                i++;
                intervals++;
            }
            Arrays.sort(count);
        }
        return intervals;
    }
}