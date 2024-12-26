class Solution {

    public int countSubsetWithKsum(int arr[],int ind,int k,int dp[][]){
        if(ind==0){
            if(k==0&&arr[ind]==0)return 2;
            if(k==0||arr[ind]==k)return 1;
            return 0;
        }
        if(dp[ind][k]!=-1)return dp[ind][k];
        int ntake=countSubsetWithKsum(arr,ind-1,k,dp);
        int take=0;
        if(arr[ind]<=k)take=countSubsetWithKsum(arr,ind-1,k-arr[ind],dp);
        return dp[ind][k]=take+ntake;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int total=0;
        for(int i=0;i<nums.length;i++)total+=nums[i];
        if(total-target<0)return 0;
        if((total-target)%2!=0)return 0;
        int dp[][]=new int [nums.length][(total-target)/2+1];
for(int i[]:dp)Arrays.fill(i,-1);
return countSubsetWithKsum(nums,nums.length-1,(total-target)/2,dp);
    }
}