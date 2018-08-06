public int findKthLargest(int[] a, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue();

        for (int i : a) {
            pq.offer(i);
            if (pq.size() > k)
                pq.poll();
        }
        return pq.peek();

}


public int findKthLargest(int[] a, int k) {

       k = a.length - k;
        int lo = 0;
        int hi = a.length - 1;
        while (lo < hi) {//类似二分法原理，根据pivot的范围一直逼近pivot
            final int pivot = partition(a, lo, hi);
            if(j < k) {
                lo = pivot + 1;
            } else if (j > k) {
                hi = pivot - 1;
            } else {
                break;
            }
        }
        return a[k];

    }

    int partition(int[] a, int lo, int hi) {
        //choose first one as pivot
        int pivot = lo, i = lo, j = hi + 1;
        while (true) {
            //find item on left to swap
            while (a[++i] < a[pivot])
                if (i == hi) break;
            //find item on right to swap
            while (a[pivot] < a[--j])
                if (j == lo) break;
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, pivot, j);//swap pivot point to  the middle
        return j;
    }

    void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
