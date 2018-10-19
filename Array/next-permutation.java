//see solution column

public int[] nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //find number a[i + 1] > a[i].
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        //find number just larger than itself among the numbers lying to its right section
        if (i >= 0) {
            int j = nums.length - 1;
            while (j < nums.length && nums[j] <= nums[i]) {
                j--;
            }
            //swap a[i] and a[j]
            swap(nums, i, j);
        }
        //reverse i + 1 till end
        reverse(nums, i + 1);
        return nums;
    }
    /*
    . Therefore, we simply need to reverse the numbers following a[i-1]a[i−1]
     to get the next smallest lexicographic permutation.
    */
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
