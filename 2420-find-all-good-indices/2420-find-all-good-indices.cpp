class Solution {
public:
    vector<int> goodIndices(vector<int>& nums, int k) {
        vector<int>ans;
        vector<int>before(nums.size());
        vector<int>after(nums.size());
        for(int i=1;i<nums.size();i++){
            if(nums[i]<=nums[i-1])before[i]=before[i-1]+1;
            else before[i]=0;
        }
        // for(int i=0;i<nums.size();i++){
        //     cout<<before[i]<<" ";

        // }
        cout<<"\n";
        
        for(int i=nums.size()-1-1;i>=0;i--){
            if(nums[i+1]>=nums[i])after[i]=after[i+1]+1;else after[i]=0;
        }
        // for(int i=0;i<nums.size();i++){
        //     cout<<after[i]<<" ";

        // }
        for(int i=k;i<nums.size()-k;i++){
            if(before[i-1]>=k-1&&after[i+1]>=k-1)ans.push_back(i);
        }return ans;

    }
};