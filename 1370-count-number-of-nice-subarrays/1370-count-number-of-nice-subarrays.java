class Solution {
    public int help(int []nums,int k){
        int l=0;
        int r=0;
        int ans=0;
        int count=0;
        while(r<nums.length){
            count+=(nums[r]%2);
            while(l<=r&&count>k){
                count-=(nums[l]%2);
                l++;

            }
            ans+=(r-l+1);//because we are counting <=k so till r to aye hoga and usse km bhi to count krenge tbhi to (k-1) minus kr kr remove kr payennge
            r++;
        }
        return ans;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return help(nums,k)-help(nums,k-1);
    }
}