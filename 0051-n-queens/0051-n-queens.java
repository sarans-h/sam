class Solution {
    public boolean isSaf(boolean board[][],int row,int col){
        int r=row;
        int c=col;
        while(r>=0){
            if(board[r][c])return false;
            r--;
        }
        r=row;
        while(r>=0&&c<board.length){
            if(board[r][c])return false;
       r--;c++;
        }
        r=row;c=col;
     while(r>=0&&c>=0){
            if(board[r][c]==true)return false;
            r--;
            c--;
        }
return true;


    }
    public void help( boolean board[][],List<List<String>>ans,int row,int total){
        if(total==0){
            List<String>al=new ArrayList<>();
            for(int i=0;i<board.length;i++){
                String s="";
                for(int j=0;j<board.length;j++){
                    if(board[i][j])s+='Q';
                    else s+='.';
                }
                al.add(s);
            }
            ans.add(al);
            return;

        }
        for(int col=0;col<board.length;col++){
            if(isSaf(board,row,col))
            {
            board[row][col]=true;
                help(board,ans,row+1,total-1);
            board[row][col]=false;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        boolean board[][]=new boolean[n][n];

        List<List<String>>ans=new ArrayList<>();
        help(board,ans,0,n);
        return ans;
        
    }
}