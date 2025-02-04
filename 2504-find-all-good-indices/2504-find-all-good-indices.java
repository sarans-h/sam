class Solution {
    public List<Integer> goodIndices(int[] security, int time) {
                int arrayBefor[]=new int[security.length];
        int arrayAfter[]=new int[security.length];
        for(int i=1;i<security.length;i++){
            if(security[i-1]>=security[i]){
                arrayBefor[i]=arrayBefor[i-1]+1;
            }
            else{
                arrayBefor[i]=0;
            }
        }
        for(int i=security.length-2;i>=0;i--){
            if(security[i+1]>=security[i]){
                arrayAfter[i]=arrayAfter[i+1]+1;
            }
            else{
                arrayAfter[i]=0;
            }
        }
    List<Integer>al=new ArrayList<>();
        for(int i=time;i<security.length-time;i++){
            if(arrayBefor[i-1]>=time-1&&arrayAfter[i+1]>=time-1)al.add(i);
        }
    return al;
    }
}