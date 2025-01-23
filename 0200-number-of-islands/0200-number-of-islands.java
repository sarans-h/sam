class Solution {
    public void bfs(char grid[][],boolean is [][],int i,int j){
        is[i][j]=true;
        int dir[][]=new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
        Queue<int[]>q=new LinkedList<>();
        q.offer(new int []{i,j});
        while(!q.isEmpty()){
            int temp[]=q.poll();
            int x=temp[0];
            int y=temp[1];
            for(int d[]:dir){
                int newx=x+d[0];
                int newy=y+d[1];
                if(newx>=0&&newy>=0&&newx<grid.length&&newy<grid[0].length&&!is[newx][newy]&& grid[newx][newy] == '1'){
                    is[newx][newy]=true;
                    q.offer(new int[]{newx,newy});
                }
            }

        }
    }   
    public int numIslands(char[][] grid) {
        boolean is[][]=new boolean[grid.length][grid[0].length];
        int c=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'&&!is[i][j]){
                    bfs(grid,is,i,j);
                    c++;
                }
            }
        }
        return c;
    }
}