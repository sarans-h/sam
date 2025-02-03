class Solution {
    class Pair{
        int dis;
        String s;
        Pair(int dis,String s){
            this.dis=dis;
            this.s=s;
            
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String>set=new HashSet<>();
        Queue<Pair>q=new LinkedList<>();
        for(String s:wordList)set.add(s);
        set.remove(beginWord);
        q.offer(new Pair(1,beginWord));
        while(!q.isEmpty()){
            Pair p=q.poll();
            String s=p.s;
            int dis=p.dis;

            if(s.equals(endWord))return dis;
            for(int i=0;i<s.length();i++){
                for(char qw='a';qw<='z';qw++){
                    char []charA=s.toCharArray();
                    charA[i]=qw;
                    if(set.contains(String.valueOf(charA))==true){
                        set.remove(String.valueOf(charA));
                        q.add(new Pair(dis+1,String.valueOf(charA)));
                    }
                }
            }
        }
        return 0;
    }
}