

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.size() == 0) return 0;

        // sort by start time
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // add first meeting
        pq.add(intervals.get(0).end);

        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);

            // if room is free
            if (curr.start >= pq.peek()) {
                pq.poll(); // reuse room
            }

            pq.add(curr.end); // allocate room
        }

        return pq.size();
    }
}