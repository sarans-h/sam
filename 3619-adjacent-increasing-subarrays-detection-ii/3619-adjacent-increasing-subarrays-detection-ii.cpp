class Solution {
public:
    int maxIncreasingSubarrays(vector<int>& nums) {
       int n=nums.size();
        int cCnt=1;
        int pCnt=1;
        int ans=0;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                cCnt++;
            }
            else{
                pCnt=cCnt;
                cCnt=1;
            }
            ans=max(ans,max(cCnt/2,min(cCnt,pCnt)));
        }
        return ans; 
    }
};