/*Binay Search Solution
    This solution is based on binary search.

At first the search space is numbers between 1 to n. Each time I select a number mid (which is the one in the middle) and count all the numbers equal to or less than mid. Then if the count is more than mid, the search space will be [1 mid] otherwise [mid+1 n]. I do this until search space is only one number.

Let's say n=10 and I select mid=5. Then I count all the numbers in the array which are less than equal mid. If the there are more than 5 numbers that are less than 5, then by Pigeonhole Principle (https://en.wikipedia.org/wiki/Pigeonhole_principle) one of them has occurred more than once. So I shrink the search space from [1 10] to [1 5]. Otherwise the duplicate number is in the second half so for the next step the search space would be [6 10].

    */
  public int findDuplicate(int[] nums) {
      int lo = 1, hi = nums.length - 1, count = 0;
      while (lo  + 1 < hi) {
          int mid = lo + (hi - lo) / 2;
          count = 0;
          for (int i : nums) {
              if (i <= mid) count++;
          }
          if (count <= mid) lo = mid;
          else             hi = mid;
      }
      count = 0;
      for (int i : nums) {
          if (i <= lo) count++;
      }
      if (count <= lo) return hi;
      return lo;

  }

/*
https://segmentfault.com/a/1190000003817671

same idea with LinkedList cycle II

i = nums[i], current node is i, next one is nums[i];
*/

public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) break;
        }

        // Find the "entrance" to the cycle.
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;

    }
