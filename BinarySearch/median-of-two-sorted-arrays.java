public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 1:brute force:  add together, and used mergort (m+n)log(m+n);
        // 2: merge two: (m+n): below method
        int i = 0, j = 0, k = 0, m = nums1.length, n = nums2.length;
        int [] nums3 = new int [m + n] ;
        while(i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                nums3[k++] = nums1[i++];
            }
            else {
                nums3[k++] = nums2[j++];
            }
        }
            while(i < m){
                nums3[k++] = nums1[i++];
            }
            while(j < n){
                nums3[k++] = nums2[j++];
            }
        if(k % 2 == 0) {// at this time, k = m + n
            return (double)(nums3[k / 2] + nums3[k / 2 - 1]) / 2;
        }
        else{
            return (double)nums3[k / 2];
        }
    }
}
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // O(log(min(m + n)));
        //code:"any number in the two left halves" <= "any number in the two right halves";
        int N1 = nums1.length, N2 = nums2.length;
        if(N1 < N2) return findMedianSortedArrays(nums2, nums1);// make sure n2 is shorter

        int lo = 0, hi = N2 * 2;
        while(lo <= hi){
            int mid2 = lo + (hi - lo) / 2;// cut 2, as base
            int mid1 = N1 + N2 -mid2;// cut 1; making left(n1,n2) = right(n1,n2)

            double L1 = (mid1 <= 0) ? Integer.MIN_VALUE : nums1[(mid1-1)/2];// if mid1 = 0, let L1 = MIN_VALUE(nums1[-1])
            double L2 = (mid2 <= 0) ? Integer.MIN_VALUE : nums2[(mid2-1)/2];
            double R1 = (mid1 >= N1 * 2) ? Integer.MAX_VALUE : nums1[mid1/2];// if mid1 = 2*N1, let R1 = MAX_VALUE(nums1[N1])
            double R2 = (mid2 >= N2 * 2) ? Integer.MAX_VALUE : nums2[mid2/2];

            //if L1 <= R2 and L2 <= R1, it is the right cut
            if (L1 > R2) lo = mid2 + 1;		// A1's lower half is too big; need to move C1 towards left (C2 towards right)
            else if (L2 > R1) hi = mid2 - 1;	// A2's lower half too big; need to move C2 towards left.
            else return (Math.max(L1,L2) + Math.min(R1, R2)) / 2;	// Otherwise, that's the right cut.
        }
        return -1;
    }
}
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if(len % 2 == 0) {
            return (findKth(nums1, 0, nums2, 0, len / 2) + findKth(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;

        }else {
            return findKth(nums1, 0, nums2, 0, len / 2 + 1);
        }
    }
    public double findKth(int[] A, int start_A, int[] B, int start_B, int k){
        if (start_A >= A.length) {
            return B[start_B + k - 1];
        }
        if (start_B >= B.length) {
            return A[start_A + k - 1];
        }

        if (k == 1) {
            return Math.min(A[start_A], B[start_B]);
        }
        int A_key = start_A + k / 2 - 1 < A.length ? A[start_A + k / 2 - 1]:Integer.MAX_VALUE;
        int B_key = start_B + k / 2- 1 < B.length ? B[start_B + k / 2 - 1]:Integer.MAX_VALUE;

        if(A_key < B_key) {
            return findKth(A, start_A + k / 2, B, start_B, k - k / 2);
        }else {
            return findKth(A, start_A, B, start_B + k / 2, k - k / 2);
        }
    }
}
