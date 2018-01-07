public int[] plusOne(int[] digits) {
    int i=digits.length-1;
    for(;i>=0;i--){
        digits[i]++;
        if(digits[i]==10) digits[i]=0;
        else return digits;
    }
    int [] result=new int[digits.length+1];
    result[0]=1;
    return result;
}


public int[] plusOne(int[] digits) {
    for (int i = digits.length - 1; i >=0; i--) {
        if (digits[i] != 9) {
            digits[i]++;
            break;
        } else {
            digits[i] = 0;
        }
    }
    if (digits[0] == 0) {
        int[] res = new int[digits.length+1];
        res[0] = 1;
        return res;
    }
    return digits;
}


public int[] plusOne(int[] digits) {

        if (digits == null || digits.length == 0) {
            return null;
        }

        int size = digits.length;
        List<Integer> list = new ArrayList<> ();

        int i = size - 1;
        boolean addDigit = false;
        while (i >= 0) {
            if (i == size - 1 && digits[i] == 9) {
                while (i >= 0 && digits[i] == 9) {
                    list.add(0);
                    i--;
                }
                if (i >= 0) {
                    list.add(digits[i] + 1);
                    i--;
                }
                else {
                    addDigit = true;
                }
            }

            if (i < -1) {
                addDigit = true;
            }
            else {
                if (i == size - 1 && digits[i] != 9) {
                    list.add(digits[i] + 1);
                }
                else if (i >= 0){
                    list.add(digits[i]);
                }
                i--;
            }

        }

        if (addDigit) {
            list.add(1);
        }

        int[] res = new int[list.size()];
        int index = list.size() - 1;
        for (Integer value : list) {
            res[index--] = value;
        }
        return res;
    }