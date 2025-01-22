class Solution {
    public long gridGame(int[][] grid) {
        long pre1[]=new long [grid[0].length];
        long pre2[]=new long [grid[0].length];
        long fluc=-1;
        int n=grid[0].length;
        pre1[0]=grid[0][0];
        pre2[n-1]=grid[1][n-1];
        for(int i=1;i<grid[0].length;i++){
            pre1[i]=pre1[i-1]+grid[0][i];

            pre2[n-i-1]=pre2[n-i]+grid[1][n-i-1];
        }
        int index=0;
    long ans=Long.MAX_VALUE;
        for(int i=0;i<grid[0].length;i++){
            long top = (i + 1 < n) ? pre1[n - 1] - pre1[i] : 0;
            long bottom = (i> 0) ? pre2[0] - pre2[i] : 0;
            ans=Math.min(ans,Math.max(top,bottom));

        }
     
        return ans;
    }
}