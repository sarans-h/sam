class Solution {
public:
    string getPermutation(int n, int k) {
       vector<int>arr;
        long fact=1;
        for(int i=1;i<n;i++){
            fact=fact*i;
            arr.push_back(i);
        }arr.push_back(n);
        string ans="";
        k--;
        while(true){
            int row=k/fact;
            ans+=to_string(arr[row]);
            arr.erase(arr.begin()+row);
            if(arr.empty())break;
            k=k%fact;
            fact=fact/arr.size();
        }
        return ans;
        
    }
};