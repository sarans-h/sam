class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        ArrayList<Character>al=new ArrayList<>();
        al.add('a');
        al.add('e');
        al.add('i');
        al.add('o');
        al.add('u');

        int pre[]=new int [words.length];
        int ans[]=new int [queries.length];
        if(al.contains(words[0].charAt(0))&&al.contains(words[0].charAt(words[0].length()-1)))pre[0]=1;
        for(int i=1;i<pre.length;i++){
            if(al.contains(words[i].charAt(0))&&al.contains(words[i].charAt(words[i].length()-1))){
                pre[i]=pre[i-1]+1;
            }
            else pre[i]=pre[i-1];
        }
        int j=0;
        for(int i[]:queries){
             if (i[0] == 0) {
                ans[j++] = pre[i[1]];
            } else {
                ans[j++] = pre[i[1]] - pre[i[0] - 1];
            }

        }
        return ans;
    }
}