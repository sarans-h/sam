class Solution {
public:
    int gmax(vector<int>&nums){
        int ans=INT_MIN;
        for(int i:nums)ans=max(i,ans);
        return ans;
    }
    
    int gmin(vector<int>&nums){
        int ans=INT_MAX;
        for(int i:nums)ans=min(i,ans);
        return ans;
    }
    int caa(vector<int>&nums,int mid,int threshold){
        int ans=0;
        for(int i :nums){
            ans+=ceil((double)i/(double)mid);
        }
        return ans<=threshold;
    }
    int smallestDivisor(vector<int>& nums, int threshold) {
        int low=1;int ans=-1;
        int high=gmax(nums);
        while(low<=high){
            int mid=(low+(high-low)/2);
            if(caa(nums,mid,threshold)){
                ans=mid;
                high=mid-1;
            }else low=mid+1;
        }
        return ans;
    }
};