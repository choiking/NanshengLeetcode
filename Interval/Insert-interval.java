public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new LinkedList<> ();
        int i = 0, size = intervals.size();
        while (i < size && intervals.get(i).end < newInterval.start) {
            res.add(intervals.get(i++));
        }
        while (i < size && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval( // we could mutate newInterval here also
                Math.min(newInterval.start, intervals.get(i).start),
                Math.max(newInterval.end, intervals.get(i).end));
            i++;
        }
        res.add(newInterval);
        //adding the res;
        while (i < size) res.add(intervals.get(i++));
        return res;
    }