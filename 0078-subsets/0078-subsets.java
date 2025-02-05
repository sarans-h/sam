class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>al=new ArrayList<>();
        for(int i=0;i<Math.pow(2,nums.length);i++){
        List<Integer>a=new ArrayList<>();

            for(int j=0;j<nums.length;j++){
                if((i&(1<<j))>0)a.add(nums[j]);
            }
        al.add(a);
        }
        return al;
    }
}