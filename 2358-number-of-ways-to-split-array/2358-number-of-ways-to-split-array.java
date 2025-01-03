class Solution {
    public int waysToSplitArray(int[] nums) {
        long pre[]=new long [nums.length];
        pre[0]=nums[0];

        for(int i=1;i<nums.length;i++){
            pre[i]=pre[i-1]+nums[i];
        }
        long[] pre2 = new long[nums.length];
        pre2[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            pre2[i]=pre2[i+1]+nums[i];
        }
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            if(pre[i]>=pre2[i+1])count++;
        }
return count;
    }
}