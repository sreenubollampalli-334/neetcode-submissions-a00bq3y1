class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for (int num : piles) {
            high = Math.max(high, num);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (koko(piles, mid) <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    static int koko(int[] piles, int k) {
        int total = 0;

        for (int pile : piles) {
            total += Math.ceil((double) pile / k);
        }

        return total;
    }
}