class Solution {
    public int help(int l,int r,int nums[]){
        if(l>r)return 0;
        int ans=0;
        for(int k=l;k<=r;k++){
            ans=Math.max(ans,nums[l-1]*nums[k]*nums[r+1]+help(l,k-1,nums)+help(k+1,r,nums));
        }
        return ans;
    }
    public int tab(int nums[]){
        int dp[][]=new int[nums.length][nums.length];
        for(int gap=2;gap<nums.length;gap++){
            for(int left=0;left+gap<nums.length;left++){
                int right=gap+left;
                for(int k=left+1;k<right;k++){
                    dp[left][right]=Math.max(dp[left][right],
                        nums[left]*nums[k]*nums[right]+dp[left][k]+dp[k][right]
                        );

                }
            }
        }
        return dp[0][nums.length-1];
        
    }
    public int maxCoins(int[] nums) {
        int ar[]=new int[nums.length+2];
        ar[0]=1;
        ar[ar.length-1]=1;
        int p=1;
        for(int i=0;i<nums.length;i++){
            ar[i+1]=nums[i];

        }
        // return help(1,nums.length,ar);
        return tab(ar);
    }
}