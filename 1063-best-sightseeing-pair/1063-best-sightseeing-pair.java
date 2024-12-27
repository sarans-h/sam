class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int dp[]=new int [values.length];
        dp[0]=values[0];
        int ans=-1;
        for(int i=1;i<values.length;i++){
            dp[i]=Math.max(values[i]+i,dp[i-1]);
            ans=Math.max(ans,dp[i-1]+values[i]-i);
        }
        return ans;
    }
}