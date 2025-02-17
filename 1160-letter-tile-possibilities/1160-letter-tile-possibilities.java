class Solution {
    Set<String>ans=new HashSet<>();
    int v[];

    public void help(String s,String ana){
ans.add(ana);
        for(int i=0;i<s.length();i++){
if(v[i]==0){
v[i]=1;
            help(s,ana+s.charAt(i));
v[i]=0;
}
        }
        // help(ind+1,s,ana);



    }
    public int numTilePossibilities(String tiles) {
   v=new int[tiles.length()];
    help(tiles,"");
    System.out.println(ans);
    return ans.size()-1;
    }
}