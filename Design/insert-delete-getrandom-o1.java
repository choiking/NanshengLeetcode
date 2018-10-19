class RandomizedSet {

    List<Integer> nums;// simply store values
    Map<Integer, Integer> locs;//record index of number, in order to use containsKey in O(1)
    Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<> ();
        locs = new HashMap<> ();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {//always insert to the end
        boolean contain = locs.containsKey(val);
        if (contain) return false;
        nums.add(val);
        locs.put(val, nums.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean contain = locs.containsKey(val);
        if (!contain) return false;
        int loc = locs.get(val);
        if (loc < nums.size() - 1) {//swap it with the last one (if it is not the last one)
            int lastoneval = nums.get(nums.size() - 1);
            nums.set(loc, lastoneval);
            locs.put(lastoneval, loc);
        }
        locs.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int randomNumber = random.nextInt(nums.size());
        return nums.get(randomNumber);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
