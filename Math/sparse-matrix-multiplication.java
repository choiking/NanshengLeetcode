class Solution {
    /*
    brute force Time limited
    */
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] res = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {//every node of res matrix
                for (int k = 0; k < A[i].length; k++) {
                    res[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return res;
    }
    //just skip every 0;
    A[0].length = B.length;
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] res = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int k = 0; k < A[0].length; k++) {//every node of A matrix
                if (A[i][k] == 0) continue;//save time
                for (int j = 0; j < B[0].length; j++) {
                    if (B[k][j] == 0) continue;// save time
                    res[i][j] += A[i][k] * B[k][j]; 
                }
            }
        }
        return res;
    }
    
    /*refer to http://www.cs.cmu.edu/~scandal/cacm/node9.html
      a sparse matrix can be represented as a sequence of rows, 
      each of which is a sequence of (column-number, value) pairs of the nonzero values in the row.
      
        A =	
            2  -1	0	0
           -1	2  -1	0
            0  -1	2  -1
            0	0  -1	2

      
      A = [[(0, 2), (1, -1)],
           [(0, -1), (1, 2), (2, -1)],       
           [(1, -1), (2, 2), (3, -1)],
           [(2, -1), (3, 2)]]

    */
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] res = new int[A.length][B[0].length];
        List<Integer>[] indexA = new List[A.length];
        for (int i = 0; i < A.length; i++) {
            List<Integer> numsA = new ArrayList<>();
            for (int k = 0; k < A[0].length; k++) {
                if (A[i][k] != 0) {
                    numsA.add(k);//column-number
                    numsA.add(A[i][k]);//value
                }
            }
            indexA[i] = numsA;
        }
        
        for (int i = 0; i < A.length; i++) {
            List<Integer> numsA = indexA[i];
            for (int p = 0; p < numsA.size(); p += 2) {//every node of A matrix
                int colA = numsA.get(p);
                int valA = numsA.get(p + 1);
                for (int j = 0; j < B[0].length; j++) {
                    res[i][j] += valA * B[colA][j]; 
                }
            }
        }
        return res;
    }
}