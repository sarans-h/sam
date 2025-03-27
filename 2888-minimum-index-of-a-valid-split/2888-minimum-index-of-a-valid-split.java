class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n=nums.size();
        HashMap<Integer,Integer>f=new HashMap<>();
        for(int i:nums){
            f.put(i,f.getOrDefault(i,0)+1);
        } 
        HashMap<Integer,Integer>f2=new HashMap<>();
        for(int i=0;i<nums.size();i++){
            f2.put(nums.get(i),f2.getOrDefault(nums.get(i),0)+1);
            if(
                f2.get(nums.get(i))>((i+1)/2)&&
            (f.get(nums.get(i))-f2.get(nums.get(i))>(n-i-1)/2))return i;
        }
return -1;
        
    }
}