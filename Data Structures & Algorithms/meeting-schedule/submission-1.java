

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {

        // sort by start time
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            Interval prev = intervals.get(i - 1);

            // check overlap
            if (curr.start < prev.end) {
                return false;
            }
        }

        return true;
    }
}