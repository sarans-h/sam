class Solution {
    int bs(int ind,int arr[][]){
        int low=ind+1;
        int ans=arr.length;
        int high=arr.length-1;
        int tar=arr[ind][1];
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid][0]>tar){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;

    }
    public int help(int ind,int k,int arr[][]){
        if(ind>=arr.length||k==0){
            return 0;
        }
        int ntake=help(ind+1,k,arr);
        int take=arr[ind][2]+help(bs(ind,arr),k-1,arr);
        return Math.max(take,ntake);
    }
    int help(int arr[][],int k){
        int n=arr.length;
        int dp[][]=new int[arr.length+1][k+1];
        int[] nextIndex = new int[n];
        for (int i = 0; i < n; i++) {
            nextIndex[i] = bs(i,arr);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= k; j++) {
                // Not pick the current event
                int notPick = dp[i + 1][j];

                // Pick the current event
                int pick = arr[i][2];
                if (nextIndex[i] < n) {
                    pick += dp[nextIndex[i]][j - 1];
                }

                dp[i][j] = Math.max(pick, notPick);
            }
        }

        return dp[0][k];
    }
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        return help(events,k);
    }
}