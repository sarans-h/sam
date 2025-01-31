class Solution {

    int parent[];
    int weight[];

    public int find(int x){
        if(parent[x]==x)return x;
        return parent[x]=find(parent[x]);
    }
    public void union(int x,int y){
        int parent_x=find(x);
        int parent_y=find(y);
        // if(parent[parent_x]==parent[parent[y]])return;
        if(parent_x==parent_y)return;
        if(weight[parent_x]<weight[parent_y]){
            parent[parent_x]=parent_y;
            weight[parent_y]+=weight[parent_x];

        }
        else if(weight[parent_x]>weight[parent_y]){
            parent[parent_y]=parent_x;
            weight[parent_x]+=weight[parent_y];
        }
        else{
            parent[parent_y]=parent_x;
            weight[parent_x]+=weight[parent_y];
        }
    }
    public int largestIsland(int[][] grid) {
        parent=new int[grid.length*grid[0].length];
        weight=new int[grid.length*grid[0].length];
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
            weight[i]=1;

        }
        int dir[][]=new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
               if(grid[r][c]==1)
               { int papaIn1d=r*grid[0].length+c;
                for(int d[]:dir){
                    int neewr=r+d[0];
                    int neewc=c+d[1];
                    if(neewr>=0&&neewc>=0&&neewc<grid[0].length&&grid.length>neewr&&grid[neewr][neewc]==1){
                        int childIn1d=neewr*grid[0].length+neewc;
                        union(papaIn1d,childIn1d);
                    }
                }}
            }
        }
        int ans=-1;
        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c]==0){
                    HashSet<Integer>set=new HashSet<>();
                    for(int d[]:dir){
                        int neewr=r+d[0];
                        int neewc=c+d[1];
                        if(neewr>=0&&neewc>=0&&neewc<grid[0].length&&grid.length>neewr&&grid[neewr][neewc]==1){
                            int childIn1d=neewr*grid[0].length+neewc;
                            set.add(find(childIn1d));
                        }
                    }
                    int size=1;
                    for(int uniq:set){
                        size+=weight[uniq];

                    }
                    ans=Math.max(ans,size);
                }

            }
        }
        return ans==-1?grid.length*grid[0].length:ans;
        


    }
}