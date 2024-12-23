class Solution {
    public int furthestBuilding(int[] heights, int b, int l) {
        int i=0;
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(i=0;i<heights.length-1;i++){
            if(heights[i]<heights[i+1]){
                int diff=heights[i+1]-heights[i];
                b-=diff;
                pq.offer(diff);
                if(b<0){
                    b+=pq.poll();
                    if(l==0)return i;
                    l--;
                }
            }

        }
        return i;

    }
}