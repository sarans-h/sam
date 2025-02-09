class Solution {
    public long countBadPairs(int[] nums) {
        long ans=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]-i)){
                ans+=map.get(nums[i]-i);
            }
            map.put(nums[i]-i,map.getOrDefault(nums[i]-i,0)+1);
        }
        long total=(long)(nums.length-1)*(nums.length)/2;
        return total-ans;
    }
}