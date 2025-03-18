class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>al=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int j=i+1;
            int k=nums.length-1;
            
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    al.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while(j<nums.length-1&&nums[j]==nums[j+1])j++;
                    while(k>0&&nums[k]==nums[k-1])k--;
                    j++;k--;
                }
                else if(nums[i]+nums[j]+nums[k]>0)k--;
                else j++;
            }

        }
        return al;
    }
}