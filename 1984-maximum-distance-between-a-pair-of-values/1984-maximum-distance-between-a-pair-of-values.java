class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int ans=0;
        for(int i=0;i<nums1.length;i++){
            int low=0;
            int high=nums2.length-1;
            int find=-1;
            while(low<=high){
                int mid=(low+high)/2;
                if(nums1[i]<=nums2[mid]){
                    find=mid;
                    low=mid+1;
                }
                else          
                high=mid-1;

            }
            if(find==-1){
                continue;
            }
            ans=Math.max(ans,find-i);

        }
        return ans;
    }
}