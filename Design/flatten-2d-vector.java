public class Vector2D implements Iterator<Integer> {
    List<Iterator> arr;
    public Vector2D(List<List<Integer>> vec2d) {//O(n)
        arr = new ArrayList<> ();
        for (List<Integer> list : vec2d) {
            if (!list.isEmpty())
                arr.add(list.iterator());
        }
    }

    @Override
    public Integer next() {//O(1)
        if (hasNext()) {
            Integer res = (Integer)arr.get(0).next();
            if (!arr.get(0).hasNext())
                arr.remove(0);
            return res;
        }
        return -1;
    }

    @Override
    public boolean hasNext() {//O(n)
        for (Iterator i : arr) {
            if (i.hasNext()) return true;
        }
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */



 public class Vector2D {

    private Iterator<List<Integer>> i;
    private Iterator<Integer> j;//every row

    public Vector2D(List<List<Integer>> vec2d) {
        i = vec2d.iterator();
    }

    public int next() {
        hasNext();
        return j.next();
    }

    public boolean hasNext() {
        while ((j == null || !j.hasNext()) && i.hasNext())
            j = i.next().iterator();
        return j != null && j.hasNext();
    }
}
