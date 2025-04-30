class Solution {
    public String longestPrefix(String s) {
        int len=0;
        int i=1;
        int lps[]=new int [s.length()];
        while(i<s.length()){
            if(s.charAt(i)==s.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }
            else{

                if(len!=0){
                    len=lps[len-1];
                }
                else{
                    lps[i]=0;
                    i++;
                }
            }
        } 
        System.out.println(Arrays.toString(lps));
        return s.substring(0,lps[s.length()-1]);

    }
}