class Solution {
     int max = 0;//max frequency
     public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<> ();//map<sum, frequence of this sum>
        getSum(root, map);

        List<Integer> res = new ArrayList<> ();
        for (int key: map.keySet()) {
            if (map.get(key) == max) {
                res.add(key);
            }
        }

        // return res.stream().mapToInt(i -> i).toArray();
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;// much more quickly than lambda method
    }

    public int getSum(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return 0;
        int curr = root.val + getSum(root.left, map) + getSum(root.right, map);
        int freq = map.getOrDefault(curr, 0) + 1;
        map.put(curr, freq);
        max = Math.max(max, freq);
        return curr;
    }
}