class Solution {
    int dp[];
      int mod = 1_000_000_007;
    public int help(int len,int zero,int one){
        if(len==0)return 1;
        if(len<0)return 0;
        if(dp[len]!=-1)return dp[len];
        int ans=0;
        if(len>=one){
            ans+=help(len-one,zero,one);
        } 
        if(len>=zero){
            ans+=help(len-zero,zero,one);
        }
        return dp[len]=ans%mod;
    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        dp=new int[high+1];
        Arrays.fill(dp,-1);
        int ans=0;
        for(int len=low;len<=high;len++){
            ans+=(help(len,zero,one));
            ans%=mod;
        }
        return ans;
    }
}