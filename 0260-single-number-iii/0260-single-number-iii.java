class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        for(int i:nums)xor^=i;
        int mask=xor&-xor;
        int buk1=0;
        int buk2=0;
        for(int i:nums){
            if((i&mask)==0)buk1^=i;
            else buk2^=i;
        }
        return new int[]{buk1,buk2};

    }
}