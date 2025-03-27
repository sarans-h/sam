class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==1)return 0;
        int dp[][]=new int [prices.length+1][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        dp[1][0] = Math.max(dp[0][0], prices[1] - prices[0]);
        dp[1][1] = Math.max(-prices[0], -prices[1]);
        for(int i=2;i<prices.length;i++){
            for(int j=0;j<=1;j++){//j==1 means buying 
                    dp[i][1]=Math.max(-prices[i]+dp[i-2][0],dp[i-1][1]);
                    dp[i][0]=Math.max(prices[i]+dp[i-1][1],dp[i-1][0]);//i-2 b/c After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
            }
        }
        return dp[prices.length-1][0];
    }
}