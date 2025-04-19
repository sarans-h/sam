class Solution {
    public int help(int ind,int nums[],int Alice){
        if(ind>=nums.length)return 0;
        
        if(Alice==1){
            int take1=nums[ind]+help(ind+1,nums,1-Alice);
            int take2=ind+1<nums.length?nums[ind]+nums[ind+1]+help(ind+2,nums,1-Alice):Integer.MIN_VALUE;
            int take3=ind+2<nums.length?nums[ind]+nums[ind+1]+nums[ind+2]+help(ind+3,nums,1-Alice):Integer.MIN_VALUE;
            return Math.max(take1,Math.max(take2,take3));
        }
        
        else{
            int take1=help(ind+1,nums,1-Alice);
            int take2=help(ind+2,nums,1-Alice);
            int take3=help(ind+3,nums,1-Alice);
            return Math.min(take1,Math.min(take2,take3));
        }
    }
    public int tab(int nums[]){
        int dp[][]=new int[nums.length+3][2];
        for(int ind=nums.length-1;ind>=0;ind--){
            for(int Alice=0;Alice<=1;Alice++){
                if(Alice==1){
                    int take1=nums[ind]+dp[ind+1][1-Alice];
                    int take2=ind+1<nums.length?nums[ind]+nums[ind+1]+dp[ind+2][1-Alice]:Integer.MIN_VALUE;
                    int take3=ind+2<nums.length?nums[ind]+nums[ind+1]+nums[ind+2]+dp[ind+3][1-Alice]:Integer.MIN_VALUE;
                    dp[ind][Alice]= Math.max(take1,Math.max(take2,take3));
                }else{
                    int take1=dp[ind+1][1-Alice];
                    int take2=dp[ind+2][1-Alice];
                    int take3=dp[ind+3][1-Alice];
                    dp[ind][Alice]=Math.min(take1,Math.min(take2,take3));
                }
            }
        }
        return dp[0][1];
    }
    public String stoneGameIII(int[] stoneValue) {
        // int aliceScore=help(0,stoneValue,1);\
        int aliceScore=tab(stoneValue);

        int bob=sum(stoneValue)-aliceScore;
        if(bob==aliceScore)return "Tie";
        else if(bob>aliceScore)return "Bob";
        else return "Alice";
    }
 private int sum(int[] stoneValues) {
        int sum = 0;
        for (int value : stoneValues) {
            sum += value;
        }
        return sum;
    }
}