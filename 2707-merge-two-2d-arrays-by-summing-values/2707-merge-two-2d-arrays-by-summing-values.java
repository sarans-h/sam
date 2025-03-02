class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int l1=0;
        int l2=0;
        int r1=nums1.length-1;
        int r2=nums2.length-1;
        ArrayList<int[]>al=new ArrayList<>();
        while(l1<=r1&&l2<=r2){
            if(nums1[l1][0]<nums2[l2][0]){
                al.add(nums1[l1]);
                l1++;
            }
            else if(nums1[l1][0]>nums2[l2][0]){
                al.add(nums2[l2]);l2++;
            }
            else {
                nums1[l1][1]=nums1[l1][1]+nums2[l2][1];
                al.add(nums1[l1]);
                l1++;l2++;
            }
        }
        while(l1<=r1){al.add(nums1[l1]);l1++;}
        while(l2<=r2){al.add(nums2[l2]);l2++;}


        return al.toArray(new int[al.size()][]);

    }
}