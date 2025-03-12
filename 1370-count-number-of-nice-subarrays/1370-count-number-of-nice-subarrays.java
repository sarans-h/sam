 

 class Solution {
    public static int help(int nums[],int k){
        int l=0;
        int r=0;
        int sum=0;
        int ans=0;

        while(r<nums.length){
            sum+=nums[r]%2;
            while(sum>k&&r>=l){
                sum-=nums[l]%2;
                l++;
            }
            ans+=(r-l+1);
            r++;
        }return ans;
    }
    public int numberOfSubarrays(int[] nums, int goal) {
        return help(nums,goal)-help(nums,goal-1);
    }
}