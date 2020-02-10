#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<bool> used;
vector<vector<string>> values;
bool cmp(vector<string> a, vector<string> b){
    return a<b;
}
void dfs(vector<vector<string>>,vector<bool>,int ,vector<string>);

vector<string> solution(vector<vector<string>> tickets) {
    vector<string> answer;
    used = vector<bool>(tickets.size());
    vector<string> temp;
    dfs(tickets, used, 0, temp);
    sort(values.begin(),values.end(),cmp);
    answer = values[0];
    return answer;
}

void dfs(vector<vector<string>> tickets,vector<bool>used,int n,vector<string> temp){
    if(n==tickets.size()){
        values.push_back(temp);
        return;
    }else{
        if(temp.size()==0){
            temp.push_back("ICN");
            dfs(tickets,used,0,temp);
        }else{
            for(int i=0;i<tickets.size();i++){
                if(used[i])
                    continue;
                if(temp.back()==tickets[i][0]){
                    temp.push_back(tickets[i][1]);
                    used[i] = true;
                    dfs(tickets,used,n+1,temp);
                    used[i] = false;
                    temp.pop_back();
                }
                    
            }
        }
    }
}
