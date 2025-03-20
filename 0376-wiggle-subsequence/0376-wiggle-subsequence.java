class Solution {
    public int help(int ind,int prev,int[]nums,int last){
        if(ind>=nums.length)return 0;
        int take=0;
        if(prev==0||(last==1&&nums[ind]-nums[prev-1]<0)){
            take=1+help(ind+1,ind+1,nums,0);
           
        }
        if(prev==0||(last==0&&nums[ind]
        -nums[prev-1]>0)){
            take=Math.max(take,1+help(ind+1,ind+1,nums,1));
        }
        int ntake=help(ind+1,prev,nums,last);

        return Math.max(take,ntake);
    }
    public int helpdp(int [][][]dp,int ind,int prev,int[]nums,int last){
        if(ind>=nums.length)return 0;
        if(dp[ind][prev][last]!=-1)return dp[ind][prev][last];
        int take=0;
        if(prev==0||(last==1&&nums[ind]-nums[prev-1]<0)){
            take=1+helpdp(dp,ind+1,ind+1,nums,0);
           
        }
        if(prev==0||(last==0&&nums[ind]
        -nums[prev-1]>0)){
            take=Math.max(take,1+helpdp(dp,ind+1,ind+1,nums,1));
        }
        int ntake=helpdp(dp,ind+1,prev,nums,last);

        return dp[ind][prev][last]=Math.max(take,ntake);
    }
    public int wiggleMaxLength(int[] nums) {
        // return help(0,0,nums,0);
        int dp[][][]=new int [nums.length+1][nums.length+1][2];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++)
            Arrays.fill(dp[i][j],-1);
        }
        return helpdp(dp,0,0,nums,0);
    }
}