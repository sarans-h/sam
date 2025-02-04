class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int arrayBefor[]=new int[security.length];
        int arrayAfter[]=new int[security.length];
        for(int i=1;i<security.length-time;i++){
            if(security[i-1]>=security[i]){
                arrayBefor[i]=arrayBefor[i-1]+1;
            }
            else{
                arrayBefor[i]=0;
            }
        }
        for(int i=security.length-2;i>=time;i--){
            if(security[i+1]>=security[i]){
                arrayAfter[i]=arrayAfter[i+1]+1;
            }
            else{
                arrayAfter[i]=0;
            }
        }
    List<Integer>al=new ArrayList<>();
        for(int i=0;i<security.length;i++){
            if(arrayBefor[i]>=time&&arrayAfter[i]>=time)al.add(i);
        }
    return al;
    }

}