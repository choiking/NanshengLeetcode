class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k < 1) return new int[] {};
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> q = new ArrayDeque<> ();
        for (int i = 0; i < nums.length; i++) {
            // while element of q out of range, remove it.
            while (!q.isEmpty() && q.peekFirst() < i - k + 1) {
                q.pollFirst();
            }
            // remove useless element
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            q.offer(i);
            // if slide win size is big enough
            if (i >= k - 1) res[index++] = nums[q.peekFirst()];
        }
        return res;
    }
}