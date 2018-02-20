class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        LinkedList<Interval> res = new LinkedList<> ();
        for (int i = 0; i < intervals.length; i++) {
            if (res.isEmpty() || res.getLast().end <= intervals[i].start) {
                res.add(intervals[i]);
            }
            else {
                return false;
            }
        }
        return true;
    }
}