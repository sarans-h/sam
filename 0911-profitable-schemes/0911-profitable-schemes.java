class Solution {
    int mod=1000000007;
    public int help(int ind,int worker,int runningProfit,int n, int minProfit, int[] group, int[] profit){
        if(ind>=group.length||worker==n){
            return minProfit<=runningProfit?1:0;
        }
        long count=(help(ind+1,worker,runningProfit,n,minProfit,group,profit))%mod;
        if(worker+group[ind]<=n){
            count=(count+help(ind+1,worker+group[ind],runningProfit+profit[ind],n,minProfit,group,profit))%mod;
        }
        return (int)count;

    }
    public int help(int n,int minProfit,int []group,int profit[]){
        int dp[][][]=new  int[group.length+1][n+1][minProfit+1];
          for (int worker = 0; worker <= n; worker++) {
            for (int p = 0; p <= minProfit; p++) {
                dp[group.length][worker][p] = (p >= minProfit) ? 1 : 0;
            }
        }
        for(int ind=group.length-1;ind>=0;ind--){
            for(int worker=0;worker<=n;worker++){
                for(int runningProfit=0;runningProfit<=minProfit;runningProfit++){
                    long count=(dp[ind+1][worker][runningProfit]);
                    if(worker>=group[ind]){
                        count=(count+dp[ind+1][worker-group[ind]][Math.min(runningProfit+profit[ind],minProfit)])%mod;
                    }
                    dp[ind][worker][runningProfit]=(int)count;
                }
            }
        }
        return dp[0][n][0];

    }
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        return help(n,minProfit,group,profit);
    }
}