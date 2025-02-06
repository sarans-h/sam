class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Long,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i!=j){
                    long product = (long) nums[i] * (long) nums[j]; 
                    map.put((product),map.getOrDefault(product,0)+1);
                }
            }
        }
        int count=0;
        for(int i:map.values()){
            i=i/2;
            if(i>1){
                count+=(i*(i-1)/2)*8;
            }
        }
        // System.out.println(map);
        return count;
    }
}