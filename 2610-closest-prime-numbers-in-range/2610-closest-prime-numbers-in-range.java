class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean arr[]=new boolean [right+1];
        Arrays.fill(arr,true);
        arr[0]=arr[1]=false;
        for(int i=2;i*i<=right;i++){
            if(arr[i])
            for(int j=i*i;j<=right;j+=i){
                arr[j]=false;
            }
        }
        List<Integer>prime=new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(arr[i])prime.add(i);
        }
        if(prime.size()<2)return new int[]{-1,-1};
        int ans=Integer.MAX_VALUE;
        int a1=-1;
        int a2=-1;
        
        for(int i=1;i<prime.size();i++){
            if(prime.get(i)-prime.get(i-1)<ans){
                ans=prime.get(i)-prime.get(i-1);
                a1=prime.get(i-1);
                a2=prime.get(i);
            }
        }
        return new int[]{a1,a2};

    }
}