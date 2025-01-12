class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        int ans=0;
        int run=0;
        for(int i=0;i<nums.length;i++){
            run+=nums[i];
            if(map.containsKey(run-k))
            ans+=map.get(run-k);
            map.put(run,map.getOrDefault(run,0)+1);
        }
        return ans;
    }
}