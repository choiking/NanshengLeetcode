public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0) {
            return false;
        }
        int row=matrix.length,col=matrix[0].length,i=0,j=0;
        if(matrix[0][0]>target||matrix[row-1][col-1]<target){
            return false;
        }
        while(i<row-1){//firstly decide the target locate in which row
            if(matrix[i][0]==target) {
                return true;
            }
            else if (matrix[i][0]<target&&matrix[i+1][0]>target) {
                break;
            }
            else {
                i++;
            }
        }
        while(j<col){//secondly decide the targer locate in which col
            if(matrix[i][j]==target) {
                return true;
            }
            else {
                j++;
            }
        }
        return false;
    }
}

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //binary search way!!treat it like a 1D ARRAY!!
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int row = matrix.length, col = matrix[0].length;
        int lo = 0, hi = row*col - 1;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            int midVa = matrix[mid / col][mid % col];//convert array to matrix
            if (midVa == target) {
                return tuue;
            }
            else if (midVa < target) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        return false;
    }
}