class Solution {
    public int characterReplacement(String s, int k) {
        int l=0;
        int r=0;
        int ans=0;
        int maxfreq=0;
        int hash[]=new int [28];
        while(r<s.length()){
            hash[s.charAt(r)-'A']++;
            maxfreq=Math.max(maxfreq,hash[s.charAt(r)-'A']);
            while(((r-l+1)-maxfreq)>k){
                hash[s.charAt(l)-'A']--;
                for(int i=0;i<26;i++){
                    maxfreq=Math.max(maxfreq,hash[i]);
                }
                l++;
            }
            if((r-l+1)-maxfreq<=k)
            ans=Math.max(ans,r-l+1);
            r++;
        }
        return ans;
    }
}