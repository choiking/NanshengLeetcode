class Solution {
    public int hIndex(int[] citations) {
        //brute force, try each possible h value
        int res = 0, size = citations.length;
        if (size == 0) return 0;
        for (int i = 1; i <= size; i++) {//all possible h
            int count = 0;
            for (int j = 0; j < size; j++) {
                if (citations[j] >= i) count++;
            }
            if (count >= i) res = i;
        }
        return res;
    }
    public int hIndex(int[] citations) {
        //sort it firstly
        int res = 0, size = citations.length;
        Arrays.sort(citations);//nlogn
        for (int i = 1; i <= size; i++) {
            if (citations[size - i] >= i) {
                res = i;
            }
        }
        return res;
    }
    /*
    Bucket sort is used when input data is with certaion range.

    */
    public int hIndex(int[] citations) {
        int size = citations.length;
        if(size == 0) return 0;
        //put into buckets
        int[] buckets = new int[size + 1];
        for(int c : citations) {
            if (c > size) buckets[size]++;
            else buckets[c]++;
        }
        int res = 0;
        //loop from right to left
        for(int i = size; i > 0; i--) {
            res += buckets[i];
            if (res >= i) return i;
        }
        return 0;
    }
}
