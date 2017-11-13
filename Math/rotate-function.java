 /*
    according to our deduction, f(k) - f(k - 1) = sum - nA[n - 1];
    so it is very easy to get every f in linear time.
    */
    public int maxRotateFunction(int[] A) {
        int len = A.length, f = 0, sum = 0;
        for (int i = 0; i < len; i++) {
            f += i * A[i];
            sum += A[i];
        }
        int max = f;
        for (int i = 1; i < len; i++) {
            f = f + sum - len * A[len - i];
            if (f > max) {
                max = f;
            }
        }
        return max;
    }