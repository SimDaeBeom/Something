#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int solution(int n, vector<vector<int>> edge) {
    int answer = 0;
    vector<vector<int>> graph(n+1,vector<int>());
    vector<bool> visit(n+1);
    vector<int> dist(n+1);
    queue<int> q;
    for(int i=0;i<edge.size();i++){
        graph[edge[i][0]].push_back(edge[i][1]);
        graph[edge[i][1]].push_back(edge[i][0]);
    }
    q.push(1);
    visit[1] = true;
    dist[1] = 0;
    
    while(!q.empty()){
        int start = q.front();
        q. pop();
        
        for(int i=0;i<graph[start].size();i++){
            if(visit[graph[start][i]]==false){
                q.push(graph[start][i]);
                visit[graph[start][i]] = true;
                dist[graph[start][i]] = dist[start] +1;
            }
        }
    }
    sort(dist.begin(),dist.end(),greater<int>());
    for(int i=0;i<dist.size();i++){
        if(dist.front()!=dist[i])
            break;
        answer++;
    }
    return answer;
}
