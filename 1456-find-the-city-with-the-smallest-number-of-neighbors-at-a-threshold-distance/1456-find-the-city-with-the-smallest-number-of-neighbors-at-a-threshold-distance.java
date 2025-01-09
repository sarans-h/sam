class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int arr[][]=new int [n][n];
        for(int i[]:arr)
        Arrays.fill(i,(int) (1e9 + 7));
        
        for(int i[]:edges){
            arr[i[0]][i[1]]=i[2];
            arr[i[1]][i[0]]=i[2];

        }
for (int i = 0; i < n; i++) {
            arr[i][i] = 0; // Distance from a city to itself is 0
        }
         for(int via=0;via<arr.length;via++){
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr.length;j++){
                    if(arr[i][j]>arr[i][via]+arr[via][j]){
                        arr[i][j]=arr[i][via]+arr[via][j];
                    }
                }    
                
            }
        }
    int fewestReachableCount=n;
    int ans=-1;
    for(int i=0;i<n;i++){
        int reach=0;
        for(int j=0;j<n;j++){
            if(i==j)continue;
            if(arr[i][j]<=distanceThreshold)reach++;
        }
        if(reach<=fewestReachableCount){
            fewestReachableCount=reach;
            ans=i;
        }
    }
    return ans;
       
    }
}