class Solution {
    public int help(int nums[],int ind,int prevInd,int lastParity){
        if(ind>=nums.length)return 0;
        int take=0;
        if(prevInd==0||(lastParity==1&&nums[ind]-nums[prevInd-1]<0)){
            take=1+help(nums,ind+1,ind+1,0);
        }
        if(prevInd==0||(lastParity==0&&nums[ind]-nums[prevInd-1]>0)){
            take=Math.max(take,1+help(nums,ind+1,ind+1,1));
        }
        int ntake=help(nums,ind+1,prevInd,lastParity);
        return Math.max(take,ntake);

    }
    public int help(int nums[]){
        int dp[][][]=new int[nums.length+2][nums.length+2][2];
        for(int ind=nums.length-1;ind>=0;ind--){
            for(int prevInd=0;prevInd<=nums.length;prevInd++){
                for(int lastParity=0;lastParity<=1;lastParity++){
                    int take=0;
                    if(prevInd==nums.length||(lastParity==1&&nums[ind]-nums[prevInd]<0)){
                        take=1+dp[ind+1][ind][0];
                    }
                    if(prevInd==nums.length||(lastParity==0&&nums[ind]-nums[prevInd]>0)){
                        take=Math.max(take,1+dp[ind+1][ind][1]);
                    }
                    int ntake=dp[ind+1][prevInd][lastParity];
                    dp[ind][prevInd][lastParity]=Math.max(take,ntake);
                }
            }
        }
        return Math.max(dp[0][nums.length][0],dp[0][nums.length][1]);

    }
    public int wiggleMaxLength(int[] nums) {
        // return help(nums,0,0,0);
        return help(nums);
    }
}