class Solution {
public:
    vector<vector<int>> minAbsDiff(vector<vector<int>>& grid, int k) {
        int m=grid.size();
        int n=grid[0].size();

        vector<vector<int>>ans(m-k+1,vector<int>(n-k+1,0));
        for(int i=0;i<=m-k;i++){
            for(int j=0;j<=n-k;j++){
                set<int>s;
                for(int p=i;p<=i+k-1;p++){
                    for(int q=j;q<=j+k-1;q++){
                        s.insert(grid[p][q]);
                    }
                }
                int minAbs=INT_MAX;
                auto prev=s.begin();
                auto curr=next(prev);
                if (s.size() <= 1) {
                    ans[i][j] = 0;
                    continue;
                }
                while(curr!=s.end()){
                    minAbs=min(minAbs,abs(*prev-*curr));
                    prev=curr;
                    curr++;
                }
                ans[i][j]=minAbs;
            }
        }
        return ans;
    }
};