class Solution {
    public int longestCycle(int[] edges) {
        return LargestSum(edges,edges.length);
    }
    				public int LargestSum(int [] edges,int n){
					int in[]=new int[n];
					for(int i=0;i<n;i++){
						if(edges[i]!=-1)in[edges[i]]++;
					}
					Queue<Integer>q=new LinkedList<>();
					boolean vis[]=new boolean[n];
					for(int i=0;i<n;i++){
						if(in[i]==0)q.offer(i);
					}
					while(!q.isEmpty()){
						int t=q.poll();
						vis[t]=true;
						if(edges[t]!=-1){
							in[edges[t]]--;
							if(in[edges[t]]==0){
								q.offer(edges[t]);
							}
						}
						
					}
					int ans=-1;
					for(int i=0;i<n;i++){
						if(vis[i]==false){
							int sum=1;
							vis[i]=true;
							int neighbour=edges[i];
							while(neighbour!=i){
								sum+=1;
								vis[neighbour]=true;
								neighbour=edges[neighbour];
							}
							ans=Math.max(ans,sum);
						}
					}
					return ans;
				}
				

}