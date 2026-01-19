class Solution {
public:
    int maxSideLength(vector<vector<int>>& grid, int threshold) {
        int n=grid[0].size();
        int m=grid.size();
        if(m==1&&n==1&&grid[0][0]<=threshold)return 1;
        vector<vector<int>>res(m,vector<int>(n));
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j==0)res[i][j]=grid[i][j];
                else res[i][j]=res[i][j-1]+grid[i][j];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=1;j<m;j++){
                res[j][i]=res[j-1][i]+res[j][i];
            }
        }int ans=0;
        for(int len=1;len<=min(m,n);len++){bool found =false;
            for(int i=0;i+len-1<m;i++){
                for(int j=0;j+len-1<n;j++){
                    int x=i+len-1;
                    int y=j+len-1;
                    int top  = x - len + 1;
                    int left = y - len + 1;

                    int sum = res[x][y];
                    if (top > 0)  sum -= res[top - 1][y];
                    if (left > 0) sum -= res[x][left - 1];
                    if (top > 0 && left > 0)
                        sum += res[top - 1][left - 1];
                    if (sum <= threshold) {
                        found = true;
                        break;
                    }

                }
                  if (found) break;
            }
             if (found) ans = len;
            else break; 
        }
        return ans;

    }
};