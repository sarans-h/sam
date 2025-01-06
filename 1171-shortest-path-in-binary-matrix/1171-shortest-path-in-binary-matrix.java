class Solution {
    public boolean safe(int x,int y,int n){
        if(x>=0&&x<=n-1&&y>=0&&y<=n-1)return true;
        return false;
    }
    public int shortestPathBinaryMatrix(int[][] grid) { 
         int n = grid.length;

        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            System.out.println("gii");
            return -1;
        }
       Queue<int[]>q=new LinkedList<>();
        q.offer(new int[]{0,0});
        grid[0][0]=1;
        int count=0;
        int[][] directions = {
            {-1, 0},  // Up
            {1, 0},   // Down
            {0, -1},  // Left
            {0, 1},   // Right
            {-1, -1}, // Top-left
            {-1, 1},  // Top-right
            {1, -1},  // Bottom-left
            {1, 1}    // Bottom-right
        };
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int temp[]=q.poll();
                int x=temp[0];
                int y=temp[1];
                if(x==n-1&&y==n-1){
                    return count+1;
                }
                for(int []dir:directions){
                    int newx=x+dir[0];
                    int newy=y+dir[1];
                    if(safe(newx,newy,n)&&grid[newx][newy]==0){
                        q.offer(new int[]{newx,newy});
                        grid[newx][newy]=1;
                    }
                }

            }
            count++;
        }
        return -1;
    }
}