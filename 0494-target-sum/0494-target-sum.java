class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=Arrays.stream(nums).sum();
        int dp[][]=new int [nums.length][2*sum+1];
        dp[0][nums[0]+sum]=1;
        dp[0][-nums[0]+sum]+=1;//because it can be 0 too
        for(int i=1;i<nums.length;i++){
            for(int j=-sum;j<sum+1;j++){
                if(sum+j+nums[i]<=2*sum)
                dp[i][sum+j]+=dp[i-1][sum+j+nums[i]];
                if(sum+j-nums[i]>=0){
                dp[i][sum+j]+=dp[i-1][sum+j-nums[i]];
                }
            }
        }
        return target+sum>=0&&target+sum<2*sum+1?dp[nums.length-1][target+sum]:0;
    }
}