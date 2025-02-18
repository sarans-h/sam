class Solution {
    public String smallestNumber(String pattern) {
        Stack<Integer>stack=new Stack<>();
        int arr[]=new int[pattern.length()+1];
        int count=1;
        for(int i=0;i<arr.length;i++){
            if(pattern.length()==i|| pattern.charAt(i)=='I'){
                arr[i]=count++;
                while(!stack.isEmpty()){
                    arr[stack.pop()]=count;
                    count++;
                }


            }
            else stack.push(i);
        }String ans="";
        for(int i:arr)ans+=String.valueOf(i);
        return ans;

    }
}