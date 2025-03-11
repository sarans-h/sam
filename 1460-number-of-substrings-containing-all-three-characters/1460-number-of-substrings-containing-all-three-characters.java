class Solution {
    public int numberOfSubstrings(String s) {
        int l=0;
        int r=0;
        int count=0;
        Map<Character,Integer>map=new HashMap<>();
        while(r<s.length()){
            char ch=s.charAt(r);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(l<r&&map.size()==3){
                count+=(s.length()-r);
                char c=s.charAt(l);
                map.put(c,map.getOrDefault(c,0)-1);
                if(map.get(c)<=0)map.remove(c);
                l++;
            }
            r++;
        }
        return count;
    }
}