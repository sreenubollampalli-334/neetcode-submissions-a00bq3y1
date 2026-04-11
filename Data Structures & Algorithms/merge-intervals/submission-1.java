

class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        List<int[]> ans = new ArrayList<>();
         Arrays.sort(intervals, (a, b) -> a[0] - b[0]);


        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < n; i++) {
            int s = intervals[i][0];
            int e = intervals[i][1];

            if (s <= end) {
                end = Math.max(end, e); // merge
            } else {
                ans.add(new int[]{start, end}); // store previous
                start = s;
                end = e;
            }
        }

        // add last interval
        ans.add(new int[]{start, end});

        return ans.toArray(new int[ans.size()][]);
    }
}