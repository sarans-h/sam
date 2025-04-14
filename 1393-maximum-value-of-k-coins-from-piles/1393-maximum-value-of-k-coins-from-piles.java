class Solution {
    public int help(int ind,int k,List<List<Integer>>al){
        if(k<=0)return 0;
        if(ind>=al.size())return 0;
        int ntake=help(ind+1,k,al);
        int take=0;
        int sum=0;
        for(int j=0;j<Math.min(k,al.get(ind).size());j++){
            sum+=al.get(ind).get(j);
            take=Math.max(take,sum+help(ind+1,k-1-j,al));
        }
        return Math.max(take,ntake);
    }
    public int tab(int m,List<List<Integer>>al){
        int dp[][]=new int[al.size()+1][m+1];
        for(int ind=al.size()-1;ind>=0;ind--){
            for(int k=1;k<=m;k++){
                int ntake=dp[ind+1][k];
                int take=0;
                int sum=0;
                for(int j=0;j<Math.min(k,al.get(ind).size());j++){
                    sum+=al.get(ind).get(j);
                    if(k-1-j>=0)
                    take=Math.max(take,sum+dp[ind+1][k-1-j]);
                    else
                    take=Math.max(take,sum);

                }
                dp[ind][k]= Math.max(take,ntake);
            }
        }
        return dp[0][m];
    }
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        // return help(0,k,piles);
        return  tab(k,piles);
    }
}