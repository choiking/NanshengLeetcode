public int search(int[] nums, int target) {
    int lo = 0, hi = nums.length - 1;
    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        long num = (nums[mid] < nums[0]) == (target < nums[0]) ? nums[mid]
            : target < nums[0] ? Long.MIN_VALUE : Long.MAX_VALUE;
        if (num > target) {
            hi = mid - 1;
        } else if (num < target) {
            lo = mid + 1;
        } else {
            return mid;
        }
    }
    return -1;
}
public int search(int[] A, int target) {
        // write your code here

        if (A == null || A.length == 0) return -1;
        if (A.length == 1) return (A[0] == target) ? 0 : -1;
        int minInLeft = A[0], pivot = 0;
        int start = 0, mid = 0, end = A.length - 1;
        //find the pivot(mid) point firstly
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] >= minInLeft && A[mid + 1] < minInLeft) {
                pivot = mid;
                break;
            }
            else if (A[mid] >= minInLeft) {
                start = mid;
            }
            else {//A[mid] < minInLeft
                end = mid;
            }
        }
        if (start + 1 == end) {
            if (A[start] >= minInLeft && A[end] < minInLeft) {
                pivot = start;
            }
            else {
                pivot = -1;//no rotated;
            }
        }
        if (target >= minInLeft && pivot != -1) {
            start = 0;
            end = pivot;
        }
        else {
            start = pivot + 1;
            end = A.length - 1;
        }

        while (start + 1 < end) {//do basic binary search
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            }
            else if (A[mid] < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (A[start] == target) return start;
        if (A[end] == target) return end;

        return -1;
    }


public int search(int[] nums, int target) {
  //without finding the pivot
   if(nums == null || nums.length == 0) return -1;
   int lo = 0, hi = nums.length - 1;
   while (lo + 1 < hi) {
       int mid = lo + (hi - lo) / 2;
       if (nums[mid] == target) {
         return mid;
       }
       //left is sorted
       if (nums[lo] < nums[mid]) {
           if (nums[lo] <= target && nums[mid] > target) {//target in left side
               hi = mid;
           }
           else {
               lo = mid;
           }
       }
       //right is sorted
       else if (nums[lo] > nums[mid]){
           if (nums[mid] < target && nums[hi] >= target) {//target in right side
               lo = mid;
           }
           else {
               hi = mid;
           }
       }
       /*
       else{
           //duplicates, we know nums[mid] != target, so nums[start] != target
           //based on current information, we can only move left pointer to skip one cell
           //thus in the worest case, we would have target: 2, and array like 11111111, then
           //the running time would be O(n)
           start++;
       }
       */
   }
    if (nums[lo] == target) return lo;
    else if (nums[hi] == target) return hi;
    else return -1;
}
