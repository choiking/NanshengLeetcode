/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    /*
    sort nO(logn)+ merge: O(n) = nO(logn)
    */
    
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        List<Interval> res = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            Interval item = intervals.get(i);
            if (!res.isEmpty()) {
                Interval last = res.get(res.size() - 1);//last one in res
                //分三种情况讨论
                if (last.end > item.end) {

                }
                else if (last.end >= item.start){
                    res.remove(res.size() - 1);
                    res.add(new Interval(last.start, item.end));
                }
                else {//last.end < item.start
                    res.add(item);
                }
            }
            else {
                res.add(item);
            }
            
        }
        for (Interval item : intervals) {
            if (res.isEmpty() || res.get(res.size() -1).end < item.start) {
                res.add(item);
            }
            else {/*merged!
                [1,3][2,6] -> [1,6]   [1,4][2,3] -> [1,4]*/
               Interval last = res.get(res.size() -1);
               last.end = Math.max(last.end, item.end);
            }
        }
        return res;
        
        
        LinkedList<Interval> res = new LinkedList<> ();//use linkdlist adt, so we can use getLast(O(1))；
        for (Interval item : intervals) {
            if (res.isEmpty() || res.getLast().end < item.start) {
                res.add(item);
            }
            else {/*merged!
                [1,3][2,6] -> [1,6]   [1,4][2,3] -> [1,4]*/
               Interval last = res.getLast();
               last.end = Math.max(last.end, item.end);
            }
        }
        return res;
    }
}