class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int dp[]=new int[nums.length+1];
        Arrays.fill(dp,1);
        int last=0;
        int ans=0;
        int n=nums.length;
        int hash[]=new int[n];
        for(int i=0;i<nums.length;i++)hash[i]=i;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0&&dp[i]<dp[j]+1){
                    hash[i]=j;
                    dp[i]=dp[j]+1;
                }
            }
            if(ans<dp[i]){
                last=i;
                ans=dp[i];
            }
        }

         List<Integer> temp = new ArrayList<>();
        temp.add(nums[last]);
        while (hash[last] != last) {
            last = hash[last];
            temp.add(nums[last]);
        }

        // Reverse the array
        Collections.reverse(temp);

        return temp;
    }
}