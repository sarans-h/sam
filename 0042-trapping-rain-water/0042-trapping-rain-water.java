class Solution {
    public int trap(int[] height) {
        int ans=0;
        Stack<Integer>stack=new Stack<>();

        for(int i=0;i<height.length;i++){
            while(!stack.isEmpty()&&height[stack.peek()]<height[i]){
                int h=height[stack.pop()];
                if(stack.isEmpty())break;
                int d=i-stack.peek()-1;
                ans=ans+(Math.min(height[stack.peek()],height[i])-h)*d;
            }
            stack.push(i);
        } 
        return ans;
    }
}