class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        int jumps = 0;
        int end = 0;   // current range end
        int far = 0;   // farthest reachable

        for (int i = 0; i < n - 1; i++) {

            far = Math.max(far, i + nums[i]);

            // when we reach the end of current jump range
            if (i == end) {
                jumps++;
                end = far;
            }
        }

        return jumps;
    }
}