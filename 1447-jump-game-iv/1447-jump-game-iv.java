class Solution {
    public int minJumps(int[] arr) {
        HashMap<Integer,HashSet<Integer>>graph=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            graph.putIfAbsent(arr[i],new HashSet<>());
            graph.get(arr[i]).add(i);
        }
        Queue<Integer>q=new LinkedList<>();
        q.add(0);

        boolean vis[]=new boolean[arr.length];
        vis[0]=true;
        int ans=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int t=q.poll();
                int left=t-1;
                int right=t+1;
                if(t==arr.length-1)return ans;
                if(left>=0&&!vis[left]){
                    q.offer(left);
                    vis[left]=true;
                }
                if(right<arr.length&&!vis[right]){
                    q.offer(right);
                    vis[right]=true;
                }
                for(int i:graph.getOrDefault(arr[t],new HashSet<>())){
                    if(!vis[i]){
                        q.offer(i);
                        vis[i]=true;
                    }
                }
                graph.remove(arr[t]);//remove because we already visited all occurence of that no so dont need to go again;

            
            }
            ans++;

        }
        return -1;
    }
}