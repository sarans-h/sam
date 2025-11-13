class Solution {
public:
    int maxOperations(string s) {
        int prev=0;int ans=0;
        if(s[0]=='1')prev++;
        for(int i=1;i<s.size();i++){
            if(s[i-1]=='0'&&s[i]=='1')ans+=prev;
            if(s[i]=='1')prev++;
        }
        if(s[s.length()-1]=='0')ans+=prev;
        return ans;
    }
};