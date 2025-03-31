class Solution {
    public int help(int r1,int c1,int r2,int c2,int nums[][]){
        int m=nums.length;
        int n=nums[0].length;
        if(r1>=m||c1>=n||r2>=m||c2>=n||nums[r1][c1] == -1 || nums[r2][c2] == -1)return Integer.MIN_VALUE;
        if(r1==m-1&&c1==n-1&&r2==m-1&&c2==n-1){
            return nums[r1][c1];
        }
        int cher=nums[r1][c1];
        if(r1!=r2&&c1!=c2){
            cher+=nums[r2][c2];
        }
        int hh=help(r1,c1+1,r2,c2+1,nums);
        int hv=help(r1,c1+1,r2+1,c2,nums);
        int vh=help(r1+1,c1,r2+1,c2,nums);
        int vv=help(r1+1,c1,r2,c2+1,nums);
        int a=Math.max(hh,Math.max(hv,Math.max(vh,vv)));
        return a+cher;
    }
    public int cherryPickup(int[][] nums) {
        // return Math.max(0,help(0,0,0,0,grid));
         int m = nums.length, n = nums[0].length;
        int[][][] dp = new int[m][n][m];

        // Initialize DP array with MIN_VALUE
        for (int[][] d1 : dp) 
            for (int[] d2 : d1) 
                Arrays.fill(d2, Integer.MIN_VALUE);

        // Base case: Last cell in the grid
         if (nums[m - 1][n - 1] != -1) {
            dp[m - 1][n - 1][m - 1] = nums[m - 1][n - 1];
        }
        // Traverse from bottom to top
        for (int r1 = m - 1; r1 >= 0; r1--) {
            for (int c1 = n - 1; c1 >= 0; c1--) {
                for (int r2 = m - 1; r2 >= 0; r2--) {
                    int c2 = r1 + c1 - r2;
                    if (c2 < 0 || c2 >= n) continue; // Ensure c2 is valid
                    if (nums[r1][c1] == -1 || nums[r2][c2] == -1) {
                        dp[r1][c1][r2] = Integer.MIN_VALUE;
                        continue;
                    }
                    int cher = nums[r1][c1];
                    if (r1 != r2) cher += nums[r2][c2]; // Avoid double counting
                    
                    // Check four possible moves
                    int maxPrev = Integer.MIN_VALUE;
                    if (r1 + 1 < m && r2 + 1 < m) maxPrev = Math.max(maxPrev, dp[r1 + 1][c1][r2 + 1]); // vv
                    if (r1 + 1 < m && c2 + 1 < n) maxPrev = Math.max(maxPrev, dp[r1 + 1][c1][r2]); // vh
                    if (c1 + 1 < n && r2 + 1 < m) maxPrev = Math.max(maxPrev, dp[r1][c1 + 1][r2 + 1]); // hv
                    if (c1 + 1 < n && c2 + 1 < n) maxPrev = Math.max(maxPrev, dp[r1][c1 + 1][r2]); // hh

                    if (maxPrev != Integer.MIN_VALUE) {
                        dp[r1][c1][r2] = cher + maxPrev;
                    }
                }
            }
        }

        return Math.max(0, dp[0][0][0]);
    }
}