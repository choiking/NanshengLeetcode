class Solution {
    public void setZeroes(int[][] matrix) {
        // using O(m + n) space;
        int row = matrix.length;
        int col = matrix[0].length;
        // boolean[] fr = new boolean[row];
        // boolean[] fc = new boolean[col];
        // // mark all 0 row and col
        // for (int i = 0; i < row; i++) {
        //     for (int j = 0; j < col; j++) {
        //         if (matrix[i][j] == 0) {
        //             fr[i] = true;
        //             fc[j] = true;
        //         }
        //     }
        // }
        // // then set zeroes
        // for (int i = 0; i < row; i++) {
        //     if (fr[i]) {
        //         for (int j = 0; j < col; j++) {
        //             matrix[i][j] = 0;
        //         }
        //     } 
        // }
        // for (int j = 0; j < col; j++) {
        //     if (fc[j]) {
        //         for (int i = 0; i < row; i++) {
        //             matrix[i][j] = 0;
        //         }
        //     } 
        // }

        
        //using O(1) space time
        boolean fr = false;
        boolean fc = false;
        //if found 0, mark the relative pos to first row and first col;
        // if found 0, mark the fr and fc
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;// which replace fr[i] in first solution
                    matrix[0][j] = 0;
                    if (i == 0) fr = true;
                    if (j == 0) fc = true;
                }
            }
        }
        for (int i = 1; i < row; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < col; j++) {
                    matrix[i][j] = 0;
                }
            } 
        }
        for (int j = 1; j < col; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < row; i++) {
                    matrix[i][j] = 0;
                }
            } 
        }
        // now take care of first row and first col
        if (fr) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }
        if (fc) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}