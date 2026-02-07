class Solution {
public:
    int minimumDeletions(string s) {
        vector<int>count_b;
        vector<int>count_a;
        int countB=0;
        int countA=0;
        for(int i=0;i<s.length();i++){
            count_b.push_back(countB);
            if(s[i]=='b')countB++;
        }
        for(int j=s.length()-1;j>=0;j--){
            count_a.push_back(countA);
            if(s[j]=='a')countA++;
        }
        reverse(count_a.begin(),count_a.end());
        int ans=s.length();
        for(int i=0;i<count_b.size();i++){
            ans=min(ans,count_b[i]+count_a[i]);
        }
        return ans;
    }
};