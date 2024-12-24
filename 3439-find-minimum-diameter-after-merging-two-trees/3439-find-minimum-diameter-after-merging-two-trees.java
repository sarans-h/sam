class Solution {
    public Map<Integer,ArrayList<Integer>> build(int edges[][]){
        Map<Integer,ArrayList<Integer>>adj=new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0]; // Starting node of the edge
            int v = edge[1]; // Ending node of the edge

            // Add edge u -> v
            adj.putIfAbsent(u, new ArrayList<>());
            adj.get(u).add(v);

            // Add edge v -> u for undirected graph (optional)
            adj.putIfAbsent(v, new ArrayList<>());
            adj.get(v).add(u);
        }
        return adj;
    }
    public int [] bfs(Map<Integer,ArrayList<Integer>>adj,int random){
        
        Queue<Integer>q=new LinkedList<>();
        q.offer(random);
        boolean is[]=new boolean[adj.size()];
        is[random]=true;
        int dis=0;
        int farthest=random;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int curr=q.poll();
                farthest=curr;
                for(int v:adj.get(curr)){
                    if(!is[v]){
                        is[v]=true;
                        q.offer(v);
                    }
                }
            }
            if(!q.isEmpty())
            dis++;
        }
        return new int[]{farthest,dis};
    }
    public int dia(Map<Integer,ArrayList<Integer>>adj){
         if (adj.isEmpty()) return 0;
        int fart[]=bfs(adj,0);
        int farthestNode=fart[0];
        int dist=fart[1];
        int diam[]=bfs(adj,farthestNode);
        int otherend=diam[0];
        int diameter=diam[1];
        return diameter;


    }
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        if(edges1.length==0&&edges2.length==0)return 1;
        Map<Integer,ArrayList<Integer>>adj1=build(edges1);
        Map<Integer,ArrayList<Integer>>adj2=build(edges2);
        int d1=dia(adj1);
        int d2=dia(adj2);
        int com=(d1+1)/2+(d2+1)/2+1;
        return Math.max(d1,Math.max(d2,com));

        
    }
}