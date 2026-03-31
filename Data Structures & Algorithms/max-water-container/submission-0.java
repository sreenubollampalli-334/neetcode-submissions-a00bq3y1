class Solution {
    public int maxArea(int[] heights) {
        int n=heights.length;
        int left=0;
        int right=n-1;
        int maxarea=0;
        while(left<=right){
            int width=right-left;
            int area=Math.min(heights[left],heights[right])*width;
            maxarea=Math.max(area,maxarea);
            if(heights[left]<heights[right]) left++;
            else right--;

        }
        return maxarea;
        
    }
}
