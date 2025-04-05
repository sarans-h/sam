class Solution { 
    public boolean help(int arr[],int ind,long sum){
        if(sum==0)return true;
        if(ind==0)return arr[ind]==sum;
        boolean np=help(arr,ind-1,sum);
        boolean p=false;
        if(arr[ind]<=sum)p=help(arr,ind-1,sum-arr[ind]);
        return p||np; 
    }
    public boolean helpDp(int arr[],int ind,int sum,int dp[][]){
        if(sum==0)return true;
        if(ind==0)return arr[ind]==sum;
        if(dp[ind][sum]!=-1)return dp[ind][sum]==0?false:true;
        boolean np=helpDp(arr,ind-1,sum,dp);
        boolean p=false;
        if(arr[ind]<=sum)p=helpDp(arr,ind-1,sum-arr[ind],dp);
        dp[ind][sum]=np||p==true?1:0;
        return np||p; 

    }
    public  boolean helpTab(int arr[],int k,int n){
        boolean dp[][]=new boolean [n][k+1];
        for(int i=0;i<n;i++)dp[i][0]=true;
        if(arr[0]<k)
        dp[0][arr[0]]=true;
        for(int ind=1;ind<n;ind++){
            for(int target=1;target<=k;target++){
                boolean np=dp[ind-1][target];
                boolean p=false;
                if(arr[ind]<=target)p=dp[ind-1][target-arr[ind]];
                dp[ind][target]=np||p;
            }
        }
        return dp[n-1][k];

    } 
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i:nums)sum+=i;
        if(sum%2!=0)return false;
        // return help(nums,nums.length-1,sum/2);
        // int dp[][]=new int[nums.length][sum/2+1];
            // for(int r[]:dp)Arrays.fill(r,-1);
        // return helpDp(nums,nums.length-1,sum/2,dp);
 return helpTab(nums,sum/2,nums.length);

    }
}