#include <string>
#include <vector>
#include <iostream>
using namespace std;

void dfs(vector<vector<int>>,int);
vector<bool> isgoing;
int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    isgoing = vector<bool>(n);
    for(int i=0;i<n;i++){
        if(!isgoing[i]){
            dfs(computers,i);
            answer++;

        }
    }
    
    return answer;
}
void dfs(vector<vector<int>>computers,int n){
    isgoing[n] = true;
    for(int j=0;j<computers.size();j++){
        if(computers[n][j] == 1&& !isgoing[j]){
            dfs(computers,j);
        }
    }
}

