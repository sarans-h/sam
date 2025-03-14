class Solution {
    public int numberOfSubstrings(String s) {
        int l=0;
        int r=0;
        int ans=0;
        Map<Character,Integer>map=new HashMap<>();
        while(r<s.length()){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            while(map.size()==3){
                ans+=(s.length()-r);
                char c=s.charAt(l);
                map.put(c,map.getOrDefault(c,0)-1);
                if(map.get(c)<=0)map.remove(c);
                l++;
            }
            r++;
        }
        return ans;
    }
}