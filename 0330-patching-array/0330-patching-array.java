class Solution {
    public int minPatches(int[] nums, int n) {
        long maxReach=0;
        int patch=0;
        int i=0;
        while(maxReach<n){
            if(i<nums.length&&maxReach+1>=nums[i]){
                maxReach=(maxReach+nums[i]);
                i++;
                 // If nums[i] is small enough (i.e., nums[i] <= maxReach + 1), it can be used to extend maxReach it increase our max reach by nums[i
            }
            else {
                maxReach=(maxReach+maxReach+1);
                 // if nums[i] is big then maxreach it means we have to patch and for instance if we can reach till 4(value of maxreach) now adding a patch we have to reach 4+1 (maxreach+1 because we need all from 1 to n so this will increase our maxreach by maxreacch+1) 
                patch++;
            }
        }   
        return patch;
    }
}












// https://youtu.be/K2IomuIFbPg?si=I813L-HeoCZQBEbQ
// class Solution {
//     public int minPatches(int[] nums, int n) {
//       int patch=0;
//       long maxReach=0;
//       int i=0;
//       while(maxReach<n){
//         if(i<nums.length&&maxReach+1>=nums[i]){
//             // If nums[i] is small enough (i.e., nums[i] <= maxReach + 1), it can be used to extend maxReach it increase our max reach by nums[i]

//             maxReach+=nums[i];
//             i++;
//         }
//         else{
//             // if nums[i] is big then maxreach it means we have to patch and for instance if we can reach till 4(value of maxreach) now adding a patch we have to reach 4+1 (maxreach+1 because we need all from 1 to n so this will increase our maxreach by maxreacch+1) 
//             maxReach+=(maxReach+1);
//             patch++;
//         }
//       }  return patch;
//     }
// }