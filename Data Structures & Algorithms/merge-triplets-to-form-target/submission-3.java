

class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int n = triplets.length;

        int[] res = new int[3]; // to store merged result

        for (int i = 0; i < n; i++) {
            int[] t = triplets[i];

            // skip invalid triplets
            if (t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) {
                continue;
            }

            // merge using max
            res[0] = Math.max(res[0], t[0]);
            res[1] = Math.max(res[1], t[1]);
            res[2] = Math.max(res[2], t[2]);
        }

        // check if we formed target
        for (int i = 0; i < 3; i++) {
            if (res[i] != target[i]) return false;
        }

        return true;
    }
}