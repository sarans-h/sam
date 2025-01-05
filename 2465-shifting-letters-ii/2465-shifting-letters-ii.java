class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int sh[]=new int [s.length()];
        for(int i[]:shifts){
            if(i[2]==1){
                sh[i[0]]++;
                if(i[1]+1<s.length()){
                    sh[i[1]+1]--;
                }
            }
            else if(i[2]==0){
                sh[i[0]]--;
                if(i[1]+1<s.length()){
                    sh[i[1]+1]++;
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        int  ind=0;
        int runner=0;
        for(char c:s.toCharArray()){
            runner=(runner+sh[ind++])%26;
            if(runner<26)runner+=26;

            sb.append((char)('a'+(c-'a'+runner)%26));

        }
        return sb.toString();
    }
}