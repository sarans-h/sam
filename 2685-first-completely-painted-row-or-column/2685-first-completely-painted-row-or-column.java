class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        HashMap<Integer,int[]>map=new HashMap<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                map.put(mat[i][j],new int[]{i,j});
            }
        }
        
        int r[]=new int[mat.length];
        int c[]=new int [mat[0].length];
        for(int j=0;j<arr.length;j++){
            int i=arr[j];
            int t[]=map.get(i);
            r[t[0]]++;
            c[t[1]]++;
            if(r[t[0]]==mat[0].length)return j;
            if(c[t[1]]==mat.length)return j;
        }
        return -1;
    }
}