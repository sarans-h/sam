class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer>pq1=new PriorityQueue<>();
        PriorityQueue<Integer>pq2=new PriorityQueue<>();
        for(int i=0;i<candidates;i++){
            pq1.add(costs[i]);
           
        }
        for(int i=Math.max(candidates,costs.length-candidates);i<costs.length;i++){
            pq2.offer(costs[i]);
        }
    System.out.println(pq1);
    System.out.println(pq2);

        long ans=0;
        int start=candidates;
        int end=costs.length-1-candidates;
        while(k-->0){
           int s = pq1.isEmpty() ? Integer.MAX_VALUE : pq1.peek();
            int e = pq2.isEmpty() ? Integer.MAX_VALUE : pq2.peek();


            if(s<=e){
                ans+=s;
                pq1.poll();
                if(start<=end)
                pq1.offer(costs[start++]);
            }
            else{
                ans+=e;
                pq2.poll();
                if(start<=end)
                pq2.offer(costs[end--]);
            }
            
        }
        return ans;
    }
}