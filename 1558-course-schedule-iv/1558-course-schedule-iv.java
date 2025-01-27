class Solution {
    public boolean dfs(HashMap<Integer, ArrayList<Integer>> adj,boolean isvis[],int src,int dest){
        isvis[src]=true;
        if(src==dest)return true;
        boolean ans=false;
        for(int v:adj.getOrDefault(src,new ArrayList<>())){
            if(!isvis[v]){
              if(dfs(adj,isvis,v,dest))return true;
            }


        }
        return ans;
    }

    public boolean bfs(  HashMap<Integer, ArrayList<Integer>> adj ,boolean vis[],int src,int dest){
        vis[src]=true;
        Queue<Integer>q=new LinkedList<>();
        q.offer(src);
       while(!q.isEmpty()){
        int curr=q.poll();
        if(curr==dest)return true;
        for(int v:adj.getOrDefault(curr, new ArrayList<>())){
            if(!vis[v]){
                q.offer(v);

                vis[v]=true;
            }
        }
       }
       return false;


    }



    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        //         HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        // for (int[] prerequisite : prerequisites) {
        //     adj.putIfAbsent(prerequisite[0], new ArrayList<>());
        //     adj.get(prerequisite[0]).add(prerequisite[1]);
        // }
        // List<Boolean>result=new ArrayList<>();
        // for(int i=0;i<queries.length;i++){
        //     boolean vis[]=new boolean[numCourses];
        //     // result.add(dfs(adj,vis,queries[i][0],queries[i][1]));
        //     result.add(bfs(adj,vis,queries[i][0],queries[i][1]));
            
        // }
        // return result;
     

        boolean pre[][]=new boolean [numCourses][numCourses];
        for(int e[]:prerequisites){
            pre[e[0]][e[1]]=true;
        }
        for(int via=0;via<numCourses;via++){
            for(int src=0;src<numCourses;src++){
                for(int target=0;target<numCourses;target++){
                    pre[src][target]=pre[src][target]||(pre[src][via]&&pre[via][target]);
                }
            }
        }
        List<Boolean> answer = new ArrayList<>();
        for (int[] query : queries) {
            answer.add(pre[query[0]][query[1]]);
        }

        return answer;


    }
}