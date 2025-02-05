class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int i=0;i<32;i++){
            int c=0;
            for(int n:nums){
                if((n&(1<<i))!=0)c++;
            }
            if(c%3==1)ans=ans|(1<<i);
        }
        return ans;
    }
}