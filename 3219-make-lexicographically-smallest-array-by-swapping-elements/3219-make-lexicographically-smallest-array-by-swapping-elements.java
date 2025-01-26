class Solution {
    int rank[];
    int parent[];
    public int find(int x){
        if(parent[x]==x)return x;
        return parent[x]=find(parent[x]);

    }
    public void union(int x,int y){
        int xparent=find(x);
        int yparent=find(y);
        if(xparent==yparent)return;
        if(rank[xparent]<rank[yparent]){
            parent[xparent]=yparent;

        }
        if(rank[xparent]>rank[yparent]){
            parent[yparent]=xparent;

        }
        if(rank[xparent]==rank[yparent]){
            parent[xparent]=yparent;
            rank[yparent]++;
        }
    }
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n=nums.length;
        parent=new int[n];
        rank=new int [n];
        for(int i=0;i<n;i++){parent[i]=i;}
        int pairs[][]=new int [n][2];
        for(int i=0;i<n;i++){
            pairs[i][0]=nums[i];
            pairs[i][1]=i;
        }
        Arrays.sort(pairs,(a,b)->a[0]-b[0]);
        for(int i=1;i<n;i++){
            if(Math.abs(pairs[i][0]-pairs[i-1][0])<=limit)union(pairs[i][1],pairs[i-1][1]);
        }
        Map<Integer,ArrayList<Integer>>map=new HashMap<>();
        for(int i=0;i<n;i++){
            int papa=find(i);
            map.putIfAbsent(papa,new ArrayList<>());
            map.get(papa).add(nums[i]);
        }
        for(ArrayList<Integer>m:map.values()){
            Collections.sort(m);
        }
        int result[]=new int [n];
        Map<Integer,Integer>groupIndex=new HashMap<>();
        for(int i=0;i<n;i++){
            int root=find(i);
            int index=groupIndex.getOrDefault(root,0);
            result[i]=map.get(root).get(index);
            groupIndex.put(root,index+1);
        }
        return result;



    }
}