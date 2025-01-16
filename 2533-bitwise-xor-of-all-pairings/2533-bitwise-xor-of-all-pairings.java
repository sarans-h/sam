class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int i:nums1)map.put(i,map.getOrDefault(i,0)+nums2.length);
        for(int i:nums2)map.put(i,map.getOrDefault(i,0)+nums1.length);
        int ans=0;

        for(int i:map.keySet()){
            if(map.get(i)%2!=0)ans^=i;
        }
        return ans;
    }
}