class Solution {
    public int numOfSubarrays(int[] arr) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int pre=0;
        map.put(1,0);
        map.put(2,1);
        int ans=0;
        for(int i=0;i<arr.length;i++){
            pre+=arr[i];
            if(pre%2==0){
                ans=(ans+map.get(1))%1000000007;
                map.put(2,map.getOrDefault(2,0)+1);
            }
            else{
                ans=(ans+map.get(2))%1000000007;
                map.put(1,map.getOrDefault(1,0)+1);
            }

        }
        return ans;
    }
}