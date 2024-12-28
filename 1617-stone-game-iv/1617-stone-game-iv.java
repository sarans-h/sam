class Solution {
    int dp[];
    public boolean help(int n){
        if(n<=0)return false;
        if(dp[n]!=-1)return dp[n]==1;
        boolean ans=false; 
        for(int i=1;i*i<=n;i++){
            if(!help(n-i*i)){//means bob looses
                ans=true;
                break;
            }
        }
        dp[n]=ans?1:0;
        return ans;
    }
    public boolean winnerSquareGame(int n) {
        dp=new int [n+1];
        Arrays.fill(dp,-1);
        return help(n);
    }
}