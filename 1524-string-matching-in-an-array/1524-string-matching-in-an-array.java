class Solution {
    public boolean find(String target,String text){
        int lps[]=new int [target.length()];
        int i=1;
        int length=0;
        while(i<target.length()){
            if(target.charAt(i)==target.charAt(length)){
                length++;
                lps[i]=length;
                i++;
            }
            else {
                if(length!=0)
                length=lps[length-1];
                else i++;
            }
        }
        int pointer1=0;
        int pointer2=0;
        while(pointer1<text.length()){
            if(text.charAt(pointer1)==target.charAt(pointer2)){
                pointer1++;pointer2++;
                if (pointer2 == target.length()) {
                    return true; // Found the target in the text
                }
            }
            else{
                if (pointer2 != 0) {
                    pointer2 = lps[pointer2 - 1];
                } else {
                    pointer1++;
                }
            }
            
        }
        return false;
    }
    public List<String> stringMatching(String[] words) {
        // return new ArrayList<>(); 
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && find(words[i], words[j])) {
                    result.add(words[i]);
                    break;
                }
            }
        }

        return result;
}
}