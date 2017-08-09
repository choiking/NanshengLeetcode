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