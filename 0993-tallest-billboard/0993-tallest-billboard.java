class Solution {
    public int help(int ind,int sum,int rods[]){
        if(ind>=rods.length){
            return sum==0?0:Integer.MIN_VALUE;
        }
        int pole1=rods[ind]+help(ind+1,sum+rods[ind],rods);
        int pole2=help(ind+1,sum-rods[ind],rods);
        int skippe=help(ind+1,sum,rods);
        return Math.max(pole1,Math.max(pole2,skippe)); 
    }
    public int sum(int arr[]){
        int s=0;
        for(int i:arr)s+=i;
        return s;

    }
    public int help(int rods[]){
         int totalSum = sum(rods);
    int offset = totalSum;
    
    // Create DP table with dimensions [index][sum + offset]
    int[][] dp = new int[rods.length + 1][2 * totalSum + 1];
    
    // Initialize all states with MIN_VALUE
    for (int sm = 0; sm <= 2 * totalSum; sm++) {
        dp[rods.length][sm] = Integer.MIN_VALUE;
    }
    
    // Base case: If we've processed all rods and sum is 0, return 0
    dp[rods.length][offset] = 0;  // This should be 0, not MIN_VALUE
    
    // Fill the table bottom-up
    for (int ind = rods.length - 1; ind >= 0; ind--) {
        for (int sm = -totalSum; sm <= totalSum; sm++) {
            int sumIndex = sm + offset;
            int result = Integer.MIN_VALUE;
            
            // Option 1: Add to pole1 (increases sum)
            if (sumIndex + rods[ind] <= 2 * totalSum) {
                int pole1 = dp[ind + 1][sumIndex + rods[ind]];
                if (pole1 != Integer.MIN_VALUE) {  // Check for MIN_VALUE, not MAX_VALUE
                    pole1 += rods[ind];
                    result = Math.max(result, pole1);
                }
            }
            
            // Option 2: Add to pole2 (decreases sum)
            if (sumIndex - rods[ind] >= 0) {
                int pole2 = dp[ind + 1][sumIndex - rods[ind]];
                result = Math.max(result, pole2);
            }
            
            // Option 3: Skip this rod
            int skip = dp[ind + 1][sumIndex];
            result = Math.max(result, skip);
            
            dp[ind][sumIndex] = result;
        }
    }
    
    // Return the maximum value when sum is 0 starting from index 0
    return Math.max(0, dp[0][offset]);
    }
    public int tallestBillboard(int[] rods) {
        return help(rods);
    }
}