class Solution {
    public int longestNiceSubarray(int[] nums) {
        int l=0;
        int r=0;
        int ans=1;
        int usedBit=0;
        while(r<nums.length){
            while(l<=r&&(usedBit & nums[r])!=0){
                usedBit^=nums[l];
                l++;
            }
            usedBit|=nums[r];
            ans=Math.max(ans,r-l+1);
            r++;
        }
    return ans;
    }
}