class Solution {
    public int[] countBits(int n) {
        int ans[]=new int[n+1];
        for(int i=0;i<=n;i++) ans[i]=i;
        int res[]=new int[ans.length];
        for(int i=0;i<ans.length;i++){
            res[i]=countBit(ans[i]);
        }
        return res;

        
    }
    static int countBit(int n){
        int cnt=0;
        while(n!=0){
            if((n&1)==1){
                cnt++;
            }
            n=n>>1;
        }
        return cnt;
    }
}
