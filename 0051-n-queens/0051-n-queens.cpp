class Solution {
public:
    vector<vector<string>>ans;
    void help(vector<vector<bool>>board,int row,int total){
        if(total==0){
            vector<string>al;
            for(int i=0;i<board.size();i++){
            string s="";
                for(int j=0;j<board.size();j++)
                if(board[i][j]){
                    s+='Q';
                }else s+='.';
                al.push_back(s);
            }
            ans.push_back(al);
            return;
        }
        for(int col=0;col<board.size();col++){
            if(isSaf(board,row,col)){
                board[row][col]=true;
                help(board,row+1,total-1);
                board[row][col]=false;
            }
        }

    }
    bool isSaf(vector<vector<bool>>board,int row,int col){
  int r=row;
        int c=col;
        while(r>=0){
            if(board[r][c])return false;
            r--;
        }
        r=row;
        while(r>=0&&c<board.size()){
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
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<bool>> board(n, vector<bool>(n, false));

        help(board,0,n);
        return ans;
    }
};