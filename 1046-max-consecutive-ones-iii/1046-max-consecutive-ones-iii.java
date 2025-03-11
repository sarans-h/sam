class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0;
        int r=0;
        int runk=0;
        int ans=0;
        while(r<nums.length){
            if(nums[r]==0)runk++;
            while(runk>k){
                if(nums[l]==0)runk--;
                l++;
            }
            ans=Math.max(ans,r-l+1);
            r++;
        }
        return ans;
    }
}