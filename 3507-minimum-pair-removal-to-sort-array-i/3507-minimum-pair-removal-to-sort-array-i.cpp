class Solution {
public:
    int minimumPairRemoval(vector<int>& nums) {
        int ans=0;
        while(nums.size()>1){
            int minsum=INT_MAX;
            bool flag=true;int ind=0;
            for(int i=1;i<nums.size();i++){
                int sum=nums[i-1]+nums[i];
                if(nums[i-1]>nums[i]){
                    flag=0;
                }
                if(sum<minsum){
                    minsum=sum;
                    ind=i-1;
                }
            }
            if(flag)break;
            ans++;
            nums[ind]=minsum;
            nums.erase(nums.begin()+ind+1);
        }
        return ans;
    }
};