class Solution {
    public int partitionDisjoint(int[] nums) {
        int leftmax=nums[0];
        int rightmin=nums[0];
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<leftmax){
                count=i+1;
                
                leftmax=rightmin;
                //  why this ? Just read lines below like a story, you will definitely get the intution
                //     Exampel : {5, 0, 3, 8, 6, 0, 10}
                //     Until i = 2, leftMax is 5
                //     Now, when we reach i = 3, we see that it's not less than leftMax (i.e. 8 > 5)
                //     So, we don't need to update partition length BUT we update our rightmin = 8
                //     Now, we go to i = 4, our leftMax is still 5 and rightmin = 8
                //     Now, we reach to i = 5, leftMax is still 5 and nums[i] is less than leftMax i.e. (0 < 5)
                //     so, we need to update our partition length to (i+1)
                //     BUT, here's the catch, After i  = 5, we need to have the leftMax as 8 and not 5 anymore.
                //     That's why we update leftMax to rightmin
                //     i.e. leftMax = rightmin;
            }
            else{
                rightmin=Math.max(nums[i],rightmin);
            }
        }
        return count;
    }
}