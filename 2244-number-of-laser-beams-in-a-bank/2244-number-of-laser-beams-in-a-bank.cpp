class Solution {
public:
    int numberOfBeams(vector<string>& bank) {
         int prev=0;
        int ans=0;
        for(string s:bank){
            int count=0;
            for(int i=0;i<s.length();i++){
                if(s[i]=='1')count++;
            }
            if(count>0){ans+=prev*count;prev=count;}
        }
        return ans;
    }
};