/*
add(i, j) Inserts the specified element at the specified position in this list. 
Shifts the element currently at that position (if any) and any subsequent elements 
to the right (adds one to their indices).

*/
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<> ();
        for (int i = 0; i < rowIndex + 1; i++) {
            res.add(0,1);
            for (int j = 1; j < res.size() - 1; j++) {
                res.set(j, res.get(j) + res.get(j + 1));
            }
        }
        return res;
    }
}

// Pascals triangles
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<> ();
        List<Integer> row = null, pre = null;
        for (int i = 0; i < numRows; i++) {
            row = new ArrayList<> ();
            for (int j = 0; j <= i; j++ ) {
                if (j == 0 || i == j) row.add(1);
                else row.add(pre.get(j - 1) + pre.get(j));
            }
            res.add(row);
            pre = row;
        }
        return res;
    }
}