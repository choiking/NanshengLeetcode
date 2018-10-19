class RandomizedCollection {

    Map<Integer, LinkedList<Integer>> indexes;
    LinkedList<Integer> vals;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        vals = new LinkedList<> (); //store all the vals
        indexes = new HashMap<> ();//(val, index of val) , values is sorted
        random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (!indexes.containsKey(val))
            indexes.put(val, new LinkedList<> ());
        System.out.println(indexes.get(val));
        indexes.get(val).add(vals.size());
        vals.add(val);

        return indexes.containsKey(val) && !indexes.get(val).isEmpty();
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        // write your code here
        if (!indexes.containsKey(val) || indexes.get(val).isEmpty()) return false;
        int lastIndexOfVal = indexes.get(val).getLast();
        //swap it with the last one (if it is NOT the last one)
        if (lastIndexOfVal < vals.size() - 1) {
            int valOfLastOne = vals.getLast();
            //update vals
            vals.set(lastIndexOfVal, valOfLastOne);
            vals.removeLast();

            //update indexes
            indexes.get(val).removeLast();
            indexes.get(valOfLastOne).removeLast();
            indexes.get(valOfLastOne).add(lastIndexOfVal);
            Collections.sort(indexes.get(valOfLastOne));//sort values  
        }
        else {
            vals.removeLast();//update vals
            indexes.get(val).removeLast();//update indexes
        }
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        // write your code here
        int randomNumber = random.nextInt(vals.size());
        return vals.get(randomNumber);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
