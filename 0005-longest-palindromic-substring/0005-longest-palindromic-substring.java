class Solution {
    public boolean isPalindrone(int i,int j,String s){
        int left=i;
        int right=j-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;right--;
           
        }
         return true;
    }
    public String longestPalindrome(String s) {
        for(int i=s.length();i>0;i--){
            for(int j=0;j<=s.length()-i;j++){
                if(isPalindrone(j,i+j,s)){
                    return s.substring(j,i+j);
                }
            }
        }
        return "";
    }
}