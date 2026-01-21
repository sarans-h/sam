class Solution {
public:
    vector<int> minBitwiseArray(vector<int>& nums) {
        vector<int>ans;
        for(int i:nums){
            for(int j=0;j<32;j++){
                if(i==2){ans.push_back(-1);break;}
                if((i&(1<<j))>0){
                    continue;
                }
                int bit=j-1;
                ans.push_back(i^(1<<bit));
                break;
            }
        }
        return ans;
    }
};