class Solution {
public:
    int maxFrequency(vector<int>& nums, int k, int numOperations) {
        unordered_map<int,int>freq;
        map<int,int>diff;
        int maxEle=*max_element(nums.begin(),nums.end());
        for(int i=0;i<nums.size();i++){
           freq[nums[i]]++;
            diff[max(0,nums[i]-k)]++;
            diff[min(nums[i]+k,maxEle)+1]--;
            diff[nums[i]]+=0;
        }
        int result=1;
        int cuSum=0;
        for(auto it=diff.begin();it!=diff.end();it++){
            int tar=it->first;
            it->second+=cuSum;
            int targetFreq=freq[tar];
            int needConversion =it->second -targetFreq;
            int maxPossible=min(needConversion,numOperations);
            result=max(result,targetFreq+maxPossible);
            cuSum=it->second;
        }
        return result;
    }
};