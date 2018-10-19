
//https://leetcode.com/problems/range-sum-query-mutable/solution/
class NumArray {

    int[] tree;
    int n;

    public NumArray(int[] nums) {
        if (nums.length != 0) {
            n = nums.length;
            tree = new int[n * 2];
            buildTree(nums);
        }
    }

    //my function
    private void buildTree(int[] nums) {
        for (int i = n, j = 0;  i < 2 * n; i++,  j++)
            tree[i] = nums[j];
        for (int i = n - 1; i > 0; --i)
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
    }


    public int sumRange(int l, int r) {//Time complexity: O(logn), Space complexity : O(1)O(1).
        //get leaf with value 'l'
        l += n;
        //get leaf with value 'l'
        r += n;
        int sum = 0;
        while (l <= r) {
            if ((l % 2) == 1) //odd number
                sum += tree[l++];
            if ((r % 2) == 0) //even number
                sum += tree[r--];
            l /= 2;
            r /= 2;
        }
        return sum;
    }

    public void update(int pos, int val) {
        pos += n;
        tree[pos] = val;
        while (pos > 0) {//一直层层往上相加
            int left = pos, right = pos;
            if (pos % 2 == 0)
                right = pos + 1;
            else
                left = pos - 1;
            // parent is updated after child is updated
            tree[pos / 2] = tree[left] + tree[right];
            pos /= 2;
        }
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
