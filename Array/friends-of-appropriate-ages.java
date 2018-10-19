//time limited exception
public int numFriendRequests(int[] ages) {
        //nlogn
        Arrays.sort(ages);
        int count = 0, n = ages.length;
        //n * n
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (ages[j] > 0.5 * ages[i] + 7) {
                    if (ages[i] == ages[j])
                        count += 2;
                    else
                        count++;
                }
            }
        }
        return count;
    }

    public int numFriendRequests(int[] ages) {

        //count all the ages's number
        int[] count = new int[121];
        for (int age : ages)
            count[age]++;

        int res = 0;

        for (int ageA = 1; ageA <= 120; ageA++) {
            int countA = count[ageA];
            for (int ageB = 1; ageB <= 120; ageB++) {
                int countB = count[ageB];
                if (ageB > 0.5 * ageA + 7 && ageB <= ageA) {
                    res += countA * countB;
                    if (ageA == ageB) {
                        //can not request itselt;
                        res -= countA;
                    }
                }
            }
        }
        return res;
    }
