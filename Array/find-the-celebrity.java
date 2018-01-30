/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int i = 1, j = 0;
        while (i < n) {
            if (knows(0, i) && !knows(i, 0)) {
                if (n == 2) {
                    if (knows(1, 0)) return - 1;
                    else return 1;
                }
                if (i == 1) j = 2;
                else j = 1;
                while (j < n) {
                    if (j != i && (!knows(j, i) || knows(i, j))) break;
                    //两种退出情况， 1: j != i 2: knows
                    j++;
                }
                if (j == n) return i;
            }
            i++;
        }
        //the following is discussing whether 0 is the celebrity, otherwise return -1.
        i = 1;
        while (i < n) {
            if (!knows(0, i) && knows(i, 0)) 
                i++;
            else return -1;
        }
        // it i = n, then n knows nobody.
        return 0;
    }
    public int findCelebrity(int n) {
        int candidate = 0;
        // it means 0 to k-1 cannot be the celebrity, because they know a previous or current candidate.
        //Also, since k knows no one between k+1 and n-1, k+1 to n-1 can not be the celebrity either. 
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i))
                candidate = i;
        }
        //strict check if candidate is celebrity
        for (int i = 0; i < n; i++) {
            if (i != candidate && (knows(candidate, i)|| !knows(i, candidate))) return -1;
            /*
            if(i<candidate && knows(candidate, i) || !knows(i, candidate)) return -1;
            if(i>candidate && !knows(i, candidate)) return -1;
            */
        }
        return candidate;
    }
}