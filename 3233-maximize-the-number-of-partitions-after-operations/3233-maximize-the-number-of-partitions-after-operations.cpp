class Solution {
public:
    string S;
    int K;
    unordered_map<long long,int>m;
    int help(int index,long uniqCount,bool canChange){
        if(index>=S.length())return 0;
        int charIndex=S[index]-'a';
        int updatedUniq=uniqCount|(1<<charIndex);
        int updatedUniqCount=__builtin_popcount(updatedUniq);
        int result=0;
        if(updatedUniqCount>K){
            result=1+help(index+1,(1<<charIndex),canChange);
        }
        else{
            result=help(index+1,updatedUniq,canChange);
        }
        if(canChange){
            for(int i=0;i<26;i++){
                int updated=uniqCount|(1<<i);
                int count=__builtin_popcount(updated);
                if(count>K){
                    result=max(1+help(index+1,(1<<i),false),result);
                }else{
                    result=max(result,help(index+1,updated,false));
                }
            }
        }
        return result;
    }
    // memo > simple memo will not work as uniqCount is a bit mask of 26 character 
    // what we can do is create a newkey of long long whose bits represent 
    // 27th bit   26bit to  1st bit       0th bit    
    //   index         uniqChar          canChange
    //so now total 28 bits neeeded

    int helpm(long long index,long uniqCount,bool canChange){
        long long key=(index<<27)|(uniqCount<<1)|canChange;
        if(index>=S.length())return 0;
        if(m.find(key)!=m.end())return m[key];
        int charIndex=S[index]-'a';
        int updatedUniq=uniqCount|(1<<charIndex);
        int updatedUniqCount=__builtin_popcount(updatedUniq);
        int result=0;
        if(updatedUniqCount>K){
            result=1+helpm(index+1,(1<<charIndex),canChange);
        }
        else{
            result=helpm(index+1,updatedUniq,canChange);
        }
        if(canChange){
            for(int i=0;i<26;i++){
                int updated=uniqCount|(1<<i);
                int count=__builtin_popcount(updated);
                if(count>K){
                    result=max(1+helpm(index+1,(1<<i),false),result);
                }else{
                    result=max(result,helpm(index+1,updated,false));
                }
            }
        }
        return m[key]=result;
    }
    int maxPartitionsAfterOperations(string s, int k) {
        S=s;
        K=k;
        return helpm(0,0,true)+1;
    }
};