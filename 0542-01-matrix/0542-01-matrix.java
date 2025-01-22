class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int ans[][]=new int[mat.length][mat[0].length];
        for(int i[]:ans){
            Arrays.fill(i,-1);
        }
        Queue<int[]>q=new LinkedList<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){q.offer(new int[]{i,j});ans[i][j]=0;}
            }
        }

        int dis[][]=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int tem[]=q.poll();
            int len=0;
            int x=tem[0];
            int y=tem[1];

            for(int i[]:dis){
                int newx=x+i[0];
                int newy=y+i[1];
                if(newx>=0&&newy>=0&&newx<mat.length&&newy<mat[0].length&&ans[newx][newy]==-1){
                    ans[newx][newy]=ans[x][y]+1;
                    q.offer(new int[]{newx,newy});
                }
            }

        }
        return ans;

    }
}