#include <string>
#include <vector>
#include <algorithm>

using namespace std;
int answer = 51;
vector<bool> ispass;
void dfs(string,string,vector<string>,int);
int solution(string begin, string target, vector<string> words) {
    ispass = vector<bool>(words.size());
    if(words.end()==find(words.begin(),words.end(),target)){
        return 0;
    }
    dfs(begin,target,words,0);
    if(answer ==51) return 0;
    return answer;
    return 1;
}
void dfs(string begin,string target,vector<string> words,int value){
    if(begin == target){
        answer = answer<value?answer:value;
        return;
    }
    for(int i=0;i<words.size();i++){
        if(ispass[i])continue;
        int count = 0;
        for(int j=0;j<begin.size();j++){
            if(words[i][j]!=begin[j])
                count++;
        }
        if(count !=1)continue;
        ispass[i] = true;
        dfs(words[i],target,words,value+1);
        ispass[i] = false;
    }

}
