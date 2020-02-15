#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(int n, vector<vector<int>> results) {
    int answer = 0;
    vector<vector<int>> graph(n+1,vector<int>(n+1));
    for(int i=0;i<results.size();i++){
        graph[results[i][0]][results[i][1]] ++;
        graph[results[i][1]][results[i][0]] --;
    }
    for(int i=1;i<n+1;i++){
        for(int j=1;j<n+1;j++){
            if(graph[i][j]==0)
                continue;
            for(int k=1;k<n+1;k++){
                if(graph[j][i]==graph[i][k]){
                    graph[j][k] = graph[j][i];
                }
            }
        }
        
    }
    for(int i=1;i<n+1;i++){
        bool temp =true;
        for(int j=1;j<n+1;j++)
        {
            if(i!=j){
                if(graph[i][j]==0){
                    temp = false;
                    break;}
            }
        }
        if(temp){
            answer++;
        }
    }
    return answer;
}
