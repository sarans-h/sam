class Solution {
    public void solve(char[][] board) {
        Queue<int[]>q=new LinkedList<>();
        for(int i=0;i<board[0].length;i++){
            if(board[0][i]=='O'){
                q.offer(new int []{0,i});
            }
            if(board[board.length-1][i]=='O'){
                q.offer(new int[]{board.length-1,i});
            }
        }
        for(int i=0;i<board.length;i++){
            if(board[i][0]=='O'){
                q.offer(new int[]{i,0});
            }
            if(board[i][board[0].length-1]=='O'){
                q.offer(new int []{i,board[0].length-1});
            }
        }
        int dir[][]=new int [][]{{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int t[]=q.poll();
            board[t[0]][t[1]]='K';
            for(int d[]:dir){
                int newx=d[0]+t[0];
                int newy=d[1]+t[1];
                if(newx>=0&&newy>=0&&newx<board.length&&newy<board[0].length&&board[newx][newy]=='O'){
                    q.offer(new int []{newx,newy});
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O')board[i][j]='X';
                if(board[i][j]=='K')board[i][j]='O';
            }
        }

    }
}