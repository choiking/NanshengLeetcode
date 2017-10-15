/*
version 1: every num has a Prime factor must not be prime;
(Sieve of Eratosthenes)

revised version: we only check sqrt(n);

because if n has factor, one of them must less than n.







*/

class Solution {
    public int countPrimes(int n) {
        //boolean default to be false;
       boolean[] notPrime = new boolean[n];
       for (int i = 2; i < n; i++) {
           if (notPrime[i] == false) {
           count++;
           //every num has a Prime factor must not be prime;
           for (j = 2; i * j < n; j++) {
               notPrime[i*j] = true;
           }
           }
       }
       return count;
}
}


class Solution {
    public int countPrimes(int n) {
        //boolean default to be false;
       boolean[] notPrime = new boolean[n];
       for (int i = 2; i < Math.sqrt(n); i++) {
           if (notPrime[i] == false) {
           //every num has a Prime factor must not be prime;
           for (int j = 2; i * j < n; j++) {
               notPrime[i*j] = true;
           }
           }
       }
        int count = 0;
        for (int i = 2; i < notPrime.length; i++) {
            if (notPrime[i] == false) count++;
        }
       return count;
}
}