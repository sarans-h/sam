class Solution {
public:
    int maximizeSquareArea(int m, int n, vector<int>& hBars, vector<int>& vBars) {
                const int MOD = 1e9 + 7;

        hBars.push_back(1);
        hBars.push_back(m);
        vBars.push_back(1);
        vBars.push_back(n);
sort(hBars.begin(),hBars.end());
sort(vBars.begin(),vBars.end());


       unordered_map<int,pair<int,int>>map;
       
        for(int i=0;i<hBars.size();i++){
            for(int j=i+1;j<hBars.size();j++){
                map[hBars[j]-hBars[i]].first++;
            }
        }
        for(int i=0;i<vBars.size();i++){
            for(int j=i+1;j<vBars.size();j++){
                map[vBars[j]-vBars[i]].second++;
            }
        }
       int ans=-1;
       for(auto &p:map){
        if (p.second.first > 0 && p.second.second > 0) {
                ans = max(ans,p.first);
            }
       }
       return ans==-1?-1:((long)ans*(long)ans)%MOD;

    }
};