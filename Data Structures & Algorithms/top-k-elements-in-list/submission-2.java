class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
       
        HashMap<Integer,Integer>mp=new HashMap<>();

        for(int i=0;i<n;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
         PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->mp.get(a)-mp.get(b));
         for(int key:mp.keySet()){
            pq.add(key);
            if(pq.size()>k) pq.poll();
         }
    int res[]=new int[k];
    for(int i=k-1;i>=0;i--){
        res[i]=pq.poll();
    }
    return res;

        
    }
}
