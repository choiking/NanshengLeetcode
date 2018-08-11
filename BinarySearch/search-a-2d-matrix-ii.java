public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //diagonal line way!!!
        if(matrix.length==0||matrix[0].length==0) return false;
        int row=matrix.length, col=matrix[0].length;
        int i=row-1,j=0;
        while(i>=0&&j<col){
            if(matrix[i][j]==target) return true;
            else if (matrix[i][j]>target) i--;
            else j++;
        }
        return false;
    }
}


//左下角（或者右上角）出发， target < this value, 排除最后一行， 否则排除第一列，一直往斜上移动
