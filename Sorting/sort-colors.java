class Solution {
    /*
     Counting sort is efficient if the range of input data is not 
     significantly greater than the number of objects to be sorted. 
     
    CountingSort
     O(n)
     three steps:
     1.put it into index
     2.modify index by adding previous one
     3.put it into res index
     */
    public void sortColors1(int[] arr) {
        int[] index = new int[3];
        //1.put it into index
        for (int i = 0; i < arr.length; i++) {
            index[arr[i]]++;
        }
        //2.modify index by adding previous one
        for (int i = 1; i < index.length; i++) {
            index[i] += index[i - 1];
        }
        //3.put it into res index
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[index[arr[i]] - 1] = arr[i];
            index[arr[i]]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res[i];
        }
    }
    /*
    First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's
    two pass
    */
    public void sortColors2(int[] arr) {
        int red = 0, white = 0;
        for (int i = 0; i < arr.length; i++) {//first count each color
            if (arr[i] == 0) {
                red++;
            }
            else if (arr[i] == 1) {
                white++;
            }
            else {
                blue++;
            }
        }
        
        for (int i = 0; i < arr.length; i++) {//overwrite array with total number of each color
            if (i < red) {
                arr[i] = 0;
            }
            else if (i < red + white) {
                arr[i] = 1;
            }
            else {
                arr[i] = 2;
            }
        }
    }
    /*
    The basic idea is using two pointers: left boundary, right boundary. Then

    1) put 0 to the left of the left boundary;    
    2) put 2 to the right of the right boundary.
    As the following:

     left boundary|         |right boundary
            00000 | 1111111 | 22222222
    */
    public void sortColors3(int[] arr) {
        int l = 0, r = arr.length - 1;
        for (int i = 0; i <= r; i++) {
            if (arr[i] == 0) {
                swap(arr, i, l++);
            }
            else if (arr[i] == 2) {
                swap(arr, i--, r--);//i-- because in case [1 2 0] -> [1 0 2], we need to move back to check again
            }
        } 
    }
    
    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.print("bdsf");
        System.out.println("dsfsfg");
    }
}