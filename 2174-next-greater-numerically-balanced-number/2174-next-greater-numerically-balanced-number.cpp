class Solution {
public:
    int nextBeautifulNumber(int n) {
        for(int i=n+1;i<=1224444;i++){
            if(is(i)){
                return i;
            }
        }return -1;
    }
    bool is(int n){
        vector<int>fre(10,0);
        while(n>0){
            fre[n%10]++;
            n/=10;
        }
        for(int i=0;i<10;i++){
            if(fre[i]>0&&fre[i]!=i)return false;
        }return true;
    }
};