class Solution {
    public int help(int ind,int m,int ALICE,int arr[]){
        if(ind>=arr.length)return 0;
        int stones=0;
        int res=ALICE==1?Integer.MIN_VALUE:Integer.MAX_VALUE;
        for(int x=1;x<=2*m&&x<arr.length-ind+1;x++){
            stones+=arr[ind+x-1];
            if(ALICE==1){
                res=Math.max(res,stones+help(ind+x,Math.max(m,x),0,arr));;
            }
            else {
                res=Math.min(res,help(ind+x,Math.max(m,x),1,arr));
            }
        }
        return res;
        
    }
        public int helpdp(int dp[][][],int ind,int m,int ALICE,int arr[]){
        if(ind>=arr.length)return 0;
        if(dp[ind][m][ALICE]!=-1)return dp[ind][m][ALICE];
        int stones=0;
        int res=ALICE==1?Integer.MIN_VALUE:Integer.MAX_VALUE;
        for(int x=1;x<=2*m&&x<arr.length-ind+1;x++){
            stones+=arr[ind+x-1];
            if(ALICE==1){
                res=Math.max(res,stones+helpdp(dp,ind+x,Math.max(m,x),0,arr));;
            }
            else {
                res=Math.min(res,helpdp(dp,ind+x,Math.max(m,x),1,arr));
            }
        }
        return dp[ind][m][ALICE]= res;
        
    }
    public int stoneGameII(int[] piles) {
        // return help(0,1,1,piles);
          int dp[][][] = new int[piles.length][piles.length+1][2];
        for(int i=0; i<piles.length; ++i){
            for(int j=0; j<=piles.length; ++j){
                Arrays.fill(dp[i][j], -1);
            }
        }
         return helpdp(dp,0,1,1,piles);
        
    }
}