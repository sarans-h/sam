class Solution {
public: 
    void rotate(string &s,int b){
        reverse(s.begin(), s.end());
        reverse(s.begin(), s.begin() + b);
        reverse(s.begin() + b, s.end());
    }
    string findLexSmallestString(string s, int a, int b) {
        queue<string>q;
        unordered_set<string>vis;
        q.push(s);
        string ans=s;
        vis.insert(s);
        while(!q.empty()){
            string t=q.front();q.pop();
            if(t<ans){
                ans=t;
            }
            // addd a 
            string temp=t;
            for(int i=1;i<s.size();i+=2){
                temp[i]=(temp[i]-'0'+a)%10+'0';
            }
            if(!vis.contains(temp)){
                vis.insert(temp);q.push(temp);
            }
            rotate(t,b);
            if(!vis.contains(t)){
                vis.insert(t);q.push(t);
            }
    
        }
        return ans;
    }
};