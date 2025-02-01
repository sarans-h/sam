class Solution {
    public boolean isBip(int []color,List<Integer>component,Map<Integer,ArrayList<Integer>>graph,int u){
        Queue<Integer>q=new LinkedList<>();
        q.offer(u);
        color[u]=1;
        component.add(u);
        while(!q.isEmpty()){
            int t=q.poll();
            for(int v:graph.get(t)){
                if(color[v]==0){
                    color[v]=-color[t];
                    q.offer(v);
                    component.add(v);
                }
                else if(color[v]==color[t])return false;


            }
        }
        return true;
    }
    public int magnificentSets(int n, int[][] edges) {
        Map<Integer,ArrayList<Integer>>graph=new HashMap<>();
        for(int i=1;i<=n;i++){
            graph.put(i,new ArrayList<>());
        }
        for(int i[]:edges){
            graph.get(i[0]).add(i[1]);
            graph.get(i[1]).add(i[0]);
        }
int ans=0;
        int color[]=new int [n+1];
        for(int i=1;i<=n;i++){
            if(color[i]==0){
                List<Integer>component=new ArrayList<>();
                if(!isBip(color,component,graph,i)){
                    return -1;
                }
                ans+=maxGroup(graph,component);
            }
        }
        return ans;
    }
    public int maxGroup(Map<Integer,ArrayList<Integer>>graph,List<Integer>component){
        int ans=0;
        for(int i=0;i<component.size();i++){
            ans=Math.max(ans,calc(component.get(i),graph));
        }
        return ans;
    }
    public int calc(int u,Map<Integer,ArrayList<Integer>>graph){
        Queue<Integer>q=new LinkedList<>();
        int dist[]=new int [graph.size()+1];
        Arrays.fill(dist,-1);
        dist[u]=1;
        q.offer(u);
        int maxLevel=1;
       while (!q.isEmpty()) {
            int t = q.poll();
            for (int v : graph.get(t)) {
                if (dist[v] == -1) {
                    dist[v] = dist[t] + 1;
                    maxLevel = Math.max(maxLevel, dist[v]);
                    q.offer(v);
                }
            }
        }
        return maxLevel;

    }
}