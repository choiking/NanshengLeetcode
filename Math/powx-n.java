//O(logn)
class Solution {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {//注意n = -n不变 overflow的问题
                ++n;
                n = -n;
                x = 1 / x;
                return x * x * myPow(x * x, n / 2);
            }
            n = -n;
            x = 1 / x;
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}

//O(n / 2)
  public double myPow(double x, int n) {
      if (n == 0) return 1;
      int i = 0;
      double res = 1;
      double df = x * x;
      int abs = Math.abs(n);
      if (abs % 2 == 0) {
          while (i < abs / 2) {
              res = res * df;
              i++;
          }
      }
      else {
          while (i < abs / 2) {
              res = res * df;
              i++;
          }
          res = res * x;
      }
      if (n < 0) return 1 / res;
      return res;
  }
//O (n / 2)
public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (x == 1)
            return x;

        double res = 1;
        if (n < 0) {
            n++;
            n = -n;
            x = 1 / x;
            res *= x;
        }
        double value = x * x;
        for (int i = 0; i < n / 2; i++) {
            res *= value;
        }
        if (n % 2 != 0)
            res *= x;

        return res;

    }
//logN
public double myPow(double x, int n) {
        long N = n;
        if (N < 0){
            x = 1 / x;
            N = -N;
        }
        double res = 1;
        while (N > 0){
            if (N % 2 == 1){
                res = res * x;
            }
            N = N / 2;每次迭代小一半， 故 logN
            x = x * x;
        }
        return res;
    }
  }
