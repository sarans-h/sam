class Solution {
    public boolean safe(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
    public int minimumEffortPath(int[][] grids) {
        int n=grids[0].length;
        int m=grids.length;
        int ans[][]=new int[m][n];
        for(int i[]:ans)Arrays.fill(i,Integer.MAX_VALUE);
        ans[0][0]=0;
        int[][] dir = {
    {0, 1}, // right
    {1, 0}, // down
    {0, -1}, // left
    {-1, 0} // up
};

        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int tem[]=pq.poll();
            int diff=tem[0];
            int x=tem[1];
            int y=tem[2];
            if(diff>ans[x][y])continue;
            for(int i[]:dir){
                int newX=x+i[0];
                int newY=y+i[1];
                if(safe(newX,newY,m,n)){
                    int diffabs=Math.abs(grids[newX][newY]-grids[x][y]);
                    int toUpdate=Math.max(diff,diffabs);
                    if(toUpdate<ans[newX][newY]){
                        ans[newX][newY]=toUpdate;
                        pq.offer(new int[]{toUpdate,newX,newY});
                    }
                }
            }

        }
        return ans[m-1][n-1];
    }
}