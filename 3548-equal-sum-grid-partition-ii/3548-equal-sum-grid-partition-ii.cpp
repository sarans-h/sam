class Solution {
public:
    bool check(int r1, int c1, int r2, int c2, int i, int j) {
        int rows = r2 - r1 + 1;
        int cols = c2 - c1 + 1;

        if (rows * cols == 1) return false;

        if (rows == 1) return (j == c1 || j == c2);
        if (cols == 1) return (i == r1 || i == r2);

        return true;
    }
typedef long long ll;
    bool canPartitionGrid(vector<vector<int>>& grid) {
        int m=grid.size();int n=grid[0].size();
        vector<ll>prerow(m,0),precol(n,0);
        map<ll,pair<int,int>>mp;
        for(int i=m-1;i>=0;i--){
            ll val=0;
            for(int j=0;j<n;j++){
                val+=grid[i][j];
                mp[grid[i][j]]={i,j};
            }
            prerow[i]=val+(i<m-1?prerow[i+1]:0);
        }
        // for(int i:prerow)cout<<i<<endl;
        for(int j=n-1;j>=0;j--){
            ll val=0;
            for(int i=0;i<m;i++){
                val+=grid[i][j];
            }
            precol[j]=val+(j<n-1?precol[j+1]:0);
        }
        // for(int i:precol)cout<<i<<endl;

        ll total=prerow[0];
        for(int i=0;i<m-1;i++){
            ll bottom=prerow[i+1];
            ll top=total-bottom;
            if(top==bottom)return true;
            ll diff=abs(top-bottom);   
            if(mp.find(diff)==mp.end())continue;
            if(top>bottom){
                auto p=mp[diff];
                if(p.first<=i&&check(0,0,i,n-1,p.first,p.second))return true;
            }
            else{
                auto p=mp[diff];
                if(p.first>i&&check(i+1,0,m-1,n-1,p.first,p.second))return true;
            }
        }
        for(int j=0;j<n-1;j++){
            ll right=precol[j+1];
            ll left=total-right;
            if(left==right)return true;
            ll diff=abs(left-right);
            if(mp.find(diff)==mp.end()){
                continue;
            }
            if(left>right){
                auto p=mp[diff];
                if(p.second<=j&&check(0,0,m-1,j,p.first,p.second))return true;
            }
            else{
                auto p=mp[diff];
                if(p.second>j&&check(0,j+1,m-1,n-1,p.first,p.second))
                return true;
            }
        }
        return 0;
    }
};