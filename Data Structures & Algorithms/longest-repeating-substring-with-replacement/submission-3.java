class Solution {
    public int characterReplacement(String s, int k) {
        int cnt[]=new  int[26];
        int left=0;
        int n=s.length();
        int maxfreq=0;
        int maxlen=0;
        for(int right=0;right<n;right++){
            cnt[s.charAt(right)-'A']++;
            maxfreq=Math.max(maxfreq,cnt[s.charAt(right)-'A']);
            while((right-left+1)-maxfreq>k){
                cnt[s.charAt(left)-'A']--;
                left++;
            }
            maxlen=Math.max(maxlen,right-left+1);

        }
        return maxlen;
        
    }
}
