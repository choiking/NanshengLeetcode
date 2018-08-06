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
        int lo = 0, hi = row*col - 1;//think it as array
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

public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        // write your code here
        int start = 0, mid = 0, end = matrix.length - 1;
        int row = 0;
        while (start + 1 < end) {
            //先用二分法确定在第几行
            mid = start + (end - start) / 2;
            if (matrix[mid][0] < target) {
                start = mid;
            }
            else if (matrix[mid][0] == target) {
                row = mid;
                break;
            }
            else {
                end = mid;
            }
        }
        if (matrix[start][0] > target) return false;
        else if (matrix[end][0] > target) row = start;
        else row = end;

        start = 0;
        end = matrix[row].length - 1;
        while (start + 1 < end) {
            //再用二分法确定在第几列
            mid = start + (end - start) / 2;
            if (matrix[row][mid] < target) {
                start = mid;
            }
            else if (matrix[row][mid] == target) {
                return true;
            }
            else {
                end = mid;
            }
        }

        if (matrix[row][start] == target || matrix[row][end] == target) {
            return true;
        }
        else {
            return false;
        }

    }
