class Solution {
    public int trap(int[] height) {
        int lmax[]=new int [height.length];
        int rmax[]=new int [height.length];
        lmax[0]=height[0];
        rmax[rmax.length-1]=height[height.length-1];
        for(int i=1;i<height.length;i++){
            lmax[i]=Math.max(lmax[i-1],height[i]);
            rmax[rmax.length-1-i]=Math.max(height[height.length-i-1],rmax[rmax.length-i]);
        }
        for(int i=0;i<lmax.length;i++){
            System.out.println(lmax[i]+" "+rmax[i]);
        }
        int ans=0;
        for(int i=0;i<rmax.length;i++){
            ans+=(Math.min(rmax[i],lmax[i])-height[i]);
        }
        return ans;
    }
}