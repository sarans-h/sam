class Solution {
    public int sum(int i){
        int ans=0;
        while(i>0){
            ans+=(i%10);
            i=i/10;
        }
        return ans;
    }
     public static int findMaxPairSum(ArrayList<Integer> list) {
        if (list.size() < 2) {
           return -1;
        }
        
        // Sort the list in descending order
        Collections.sort(list, Collections.reverseOrder());
        
        // The maximum pair sum is the sum of the two largest elements
        return list.get(0) + list.get(1);
    }
    public int maximumSum(int[] nums) {
        HashMap<Integer,ArrayList<Integer>>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.putIfAbsent(sum(nums[i]),new ArrayList<>());
            map.get(sum(nums[i])).add(nums[i]);
        }
        int max=Integer.MIN_VALUE;
        for (ArrayList<Integer> values : map.values()) {

            if(values.size()>=2){
                System.out.println(values);
                max=Math.max(max,findMaxPairSum(values));
            }
        }
        return max==Integer.MIN_VALUE?-1:max;
    }
}