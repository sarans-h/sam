class Solution {
    public int distance(int i,int j,int points[][]){
        return Math.abs(points[i][1]-points[j][1])+Math.abs(points[i][0]-points[j][0]);
    }
    public int prims(int points[][]){        
HashSet<Integer>visited=new HashSet<>();
int sum=0;
PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
pq.offer(new int[]{0,0});
while(!pq.isEmpty()){
    int t[]=pq.poll();
    if(visited.contains(t[1]))continue;                                                                        
    visited.add(t[1]);
    sum+=t[0];
    for(int i=0;i<points.length;i++){
        if(!visited.contains(i)){
            pq.offer(new int []{distance(t[1],i,points),i});
        }
    }
}

        return sum;}
    int rank[];
    int parent[];
    public void union(int x,int y){
        int xparent=find(x);
        int yparent=find(y);
        if(xparent==yparent)return;
        if(rank[xparent]>rank[yparent]){
            parent[yparent]=xparent;
        }
        else if(rank[xparent]<rank[yparent]){
            parent[xparent]=yparent;
        }
        else{
            parent[xparent]=yparent;
            rank[yparent]++;
        }
    }
    public int find(int x){
        if(parent[x]==x)return x;
        return parent[x]=find(parent[x]);
    }
    public int krushkal(int points[][]){
        int n=points.length;
        rank = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        // int n = points.length;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) +
                           Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{dist, i, j}); // [distance, point1, point2]
            }
        }
        Collections.sort(edges,(a,b)->(a[0]-b[0]));
        int ans=0;
        int edg=0;
        for(int i[]:edges){
            int wt=i[0];
            int u=i[1];
            int v=i[2];
            if(find(u)!=find(v)){
                union(u,v);
                ans+=wt;
                edg++;
                if(edg==points.length-1)break;
            }
        }
        return ans;
    }
    public int minCostConnectPoints(int[][] points) {
        return prims(points);
        // return krushkal(points);

    }
}