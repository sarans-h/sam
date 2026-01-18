class Solution {
public:
    int largestMagicSquare(vector<vector<int>>& grid) {
        int n=grid[0].size();
        int m=grid.size();
        vector<vector<int>>rSum(m,vector<int>(n));
        for(int i=0;i<m;i++)rSum[i][0]=grid[i][0];
        for(int i=0;i<m;i++){
            for(int j=1;j<n;j++){
                rSum[i][j]=rSum[i][j-1]+grid[i][j];
            }
        }
        
        vector<vector<int>>cSum(m,vector<int>(n));
       for(int j = 0; j < n; j++)
    cSum[0][j] = grid[0][j];
      for(int i = 1; i < m; i++){
    for(int j = 0; j < n; j++){
        cSum[i][j] = cSum[i-1][j] + grid[i][j];
    }
}
        for(int edge=min(m,n);edge>=2;edge--){
            for(int i=0;i+edge<=m;i++){
                for(int j=0;j+edge<=n;j++){
                    int standrd=rSum[i][j+edge-1]-(j>0?rSum[i][j-1]:0);
                    bool check=true;
                    for(int p=i+1;p<i+edge;p++){
                        if((rSum[p][j+edge-1]-(j>0?rSum[p][j-1]:0))!=standrd){
                            check=false;break;
                        }
                    }
                    if(!check)continue;
                    for(int p=j;p<j+edge;p++){
                        if(cSum[i+edge-1][p]-(i>0?cSum[i-1][p]:0)!=standrd){
                            check=false;break;
                        }
                    }
                    if(!check)continue;
                    int d1 = 0, d2 = 0;
                    // sum directly by traversing without using the prefix sum.
                    for (int k = 0; k < edge; ++k) {
                        d1 += grid[i + k][j + k];
                        d2 += grid[i + k][j + edge - 1 - k];
                    }
                    if (d1 == standrd && d2 == standrd) {
                        return edge;
                    }
                }

            }
        }return 1;
    }
};