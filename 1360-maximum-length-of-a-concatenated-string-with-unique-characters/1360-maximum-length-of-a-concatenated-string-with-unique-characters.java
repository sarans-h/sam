class Solution {
    public int help(int ind,List<String>arr,String temp){
        if(ind>=arr.size())return temp.length();
        int exclude=0;
        int include=0;
        if(!hasDuplicate(temp,arr.get(ind))){
            exclude=help(ind+1,arr,temp);
        }else{
            
            include=help(ind+1,arr,temp+arr.get(ind));
            exclude=help(ind+1,arr,temp);
        }
        return Math.max(include,exclude);
    }
    private boolean havecommonBit(int mask, String s) {
        int newMask = 0;
        for (char c : s.toCharArray()) {
            int bit = (1 << (c - 'a'));
            if ((mask & bit) != 0) return true; // Found common character
            if ((newMask & bit) != 0) return true; // Duplicate in `s`
            newMask |= bit;
        }
        return false;
    }
    public int help(int ind,List<String>arr,int mask){
        if(ind>=arr.size())return Integer.bitCount(mask);
        int exclude=0;
        int include=0;
        exclude=help(ind+1,arr,mask);
        if(!havecommonBit(mask,arr.get(ind))){
            String s=arr.get(ind);
            for(int i=0;i<arr.get(ind).length();i++){
                mask=mask|(1<<(s.charAt(i)-'a'));
            }
            include=help(ind+1,arr,mask);
        }
        return Math.max(include,exclude);
    }
    public boolean hasDuplicate(String s1,String s2){
        int arr[]=new int[26];
        for(char c:s1.toCharArray()){
            if(arr[c-'a']>0)return false;
            arr[c-'a']++;
        }
        for(char c:s2.toCharArray()){
            if(arr[c-'a']>0)return false;
            arr[c-'a']++;
        }
        return true;
    }
    public int maxLength(List<String> arr) {
        // return help(0,arr,"");
        return help(0,arr,0);
    }
}