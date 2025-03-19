class Solution {
    public int aliceBest(int ind,int nums[],char turn){
        if(ind>=nums.length)return 0;
        if(turn=='A'){
            int take1=Integer.MIN_VALUE;
            int take2=Integer.MIN_VALUE;
            int take3=Integer.MIN_VALUE;
            if(ind<nums.length)take1=nums[ind]+aliceBest(ind+1,nums,'B');
            if(ind+1<nums.length)take2=nums[ind]+nums[ind+1]+aliceBest(ind+2,nums,'B');
            if(ind+2<nums.length)take3=nums[ind]+nums[ind+1]+nums[ind+2]+aliceBest(ind+3,nums,'B');
            return Math.max(take1,Math.max(take2,take3));
        }
        else{
            int take1=Integer.MAX_VALUE;
            int take2=Integer.MAX_VALUE;
            int take3=Integer.MAX_VALUE;
            take1=aliceBest(ind+1,nums,'A');
            take2=aliceBest(ind+2,nums,'A');
            take3=aliceBest(ind+3,nums,'A');
            return Math.min(take1,Math.min(take2,take3));
        }
    }
    public int help(int nums[]){
        int dp[][]=new int [nums.length+1][2];
        for(int ind=nums.length-1;ind>=0;ind--){
            for(int turn =0;turn <=1;turn++){
                 if(turn==0){
                    int take1=Integer.MIN_VALUE;
                    int take2=Integer.MIN_VALUE;
                    int take3=Integer.MIN_VALUE;
                    if(ind<nums.length)take1=nums[ind]+dp[ind+1][1];
                    if(ind+1<nums.length)take2=nums[ind]+nums[ind+1]+dp[ind+2][1];
                    if(ind+2<nums.length)take3=nums[ind]+nums[ind+1]+nums[ind+2]+dp[ind+3][1];
                    dp[ind][turn]=Math.max(take1,Math.max(take2,take3));
                }
                else{
                    int take1=0;
                    int take2=0;
                    int take3=0;
                    if(ind+1<nums.length)
                    take1=dp[ind+1][0];
                    if(ind+2<nums.length)
                    take2=dp[ind+2][0];
                    if(ind+3<nums.length)
                    take3=dp[ind+3][0];
                    dp[ind][turn]= Math.min(take1,Math.min(take2,take3));
                }
            }
        }
        return dp[0][0];
    }
    public String stoneGameIII(int[] stoneValue) {
        // int aliceScore = aliceBest(0, stoneValue, 'A');
        int aliceScore=help(stoneValue);
        // System.out.println(aliceScore);
        int totalSum = calculateTotalSum(stoneValue);
        int bobScore = totalSum - aliceScore;

        if (aliceScore > bobScore) {
            return "Alice";
        } else if (aliceScore < bobScore) {
            return "Bob";
        } else {
            return "Tie";
        } 
    } private int calculateTotalSum(int[] stoneValues) {
        int sum = 0;
        for (int value : stoneValues) {
            sum += value;
        }
        return sum;
    }
}