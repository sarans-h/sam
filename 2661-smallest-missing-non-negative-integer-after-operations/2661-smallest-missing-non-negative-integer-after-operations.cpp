class Solution {
public:
    int findSmallestInteger(vector<int>& nums, int value) {
        unordered_map<int,int>map;
        for(int i=0;i<nums.size();i++){
            map[(nums[i]%value+value)%value]++;
        }
        int ans=0;
        while(true){

            if(map[(ans%value+value)%value]>0){
                map[(ans%value+value)%value]--;
            }else{
                return ans;
            }
            ans++;
        }
        return -1;
    }
};