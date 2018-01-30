
//uses min heap, average time complexity is O(nlogn).
public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1.start - o2.start);
        if (intervals.length == 0) {
            return 0;
        }
        PriorityQueue<Interval> heap = new PriorityQueue<>(intervals.length, (o1, o2) -> o1.end - o2.end);

        heap.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            //get the earliest finish room
            Interval item = heap.poll();

            // if the current meeting starts right after
            // there's no need for a new room, merge the interval
            if (item.end <= intervals[i].start) {
                item.end = intervals[i].end;
            }
            else {
                // otherwise, this meeting needs a new room
                heap.offer(intervals[i]);
            }

            //don't forget to put the meeting room back
            heap.offer(item);
        }

        return heap.size();
    }