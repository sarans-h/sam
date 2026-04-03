class Solution {
public:
    vector<vector<int>>dp;
    struct cmp{
        bool operator()(const pair<int,int>&a,const pair<int,int>&b){
            return a.first<b.first;
        }
    };
    int count(vector<int>&walls,int start,int end){
        int left=lower_bound(walls.begin(),walls.end(),start)-walls.begin();
        int right=upper_bound(walls.begin(),walls.end(),end)-walls.begin();
        return right-left;
    }
    int help(int i,int dir,vector<pair<int,int>>&range,vector<pair<int,int>>&rowdis,vector<int>&walls){
        if(i==rowdis.size())return 0;
        if(dp[i][dir]!=-1)return dp[i][dir];
        int leftstart=range[i].first;
        if(dir==1){
            leftstart=max(i==0?1:range[i-1].second+1,leftstart);
        }
        int leftWallCount=count(walls,leftstart,rowdis[i].first)+help(i+1,0,range,rowdis,walls);
        int lrightWallCount=count(walls,rowdis[i].first,range[i].second)+help(i+1,1,range,rowdis,walls);
        return dp[i][dir]=max(leftWallCount,lrightWallCount);
    }
    int maxWalls(vector<int>& robots, vector<int>& distance, vector<int>& walls) {
        int n=robots.size();
        dp = vector<vector<int>>(n, vector<int>(2, -1));
        vector<pair<int,int>>rowdis;
        for(int i=0;i<robots.size();i++){
            rowdis.push_back({robots[i],distance[i]});
        }
        sort(rowdis.begin(),rowdis.end(),cmp());
        sort(walls.begin(),walls.end());
        vector<pair<int,int>>range;
        for(int i=0;i<robots.size();i++){
            auto ith=rowdis[i];

            int l=max(ith.first-ith.second,((i==0)?1:rowdis[i-1].first+1));
            int r=min(ith.first+ith.second,((i==robots.size()-1)?(int)1e9:rowdis[i+1].first-1));
            range.push_back({l,r});
        }

        return help(0,0,range,rowdis,walls);
    }
};