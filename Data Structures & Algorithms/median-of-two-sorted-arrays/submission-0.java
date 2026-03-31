class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
          int n = nums1.length;
        int m = nums2.length;

        int i = 0, j = 0;
        int count = 0;
        int mid1 = -1, mid2 = -1;

        int total = n + m;

        while(count <= total / 2) {

            mid1 = mid2;

            if(i < n && (j >= m || nums1[i] <= nums2[j])) {
                mid2 = nums1[i++];
            } else {
                mid2 = nums2[j++];
            }

            count++;
        }

        if(total % 2 == 0)
            return (mid1 + mid2) / 2.0;

        return mid2;
    }
}
