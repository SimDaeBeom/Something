#include <string>
#include <vector>
#include <queue>


using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;
    priority_queue<int> pq;
    queue<pair<int,int>> qu;
    int size = priorities.size();
    for(int i=0;i<size;i++){
        qu.push(make_pair(i,priorities[i]));
        pq.push(priorities[i]);
    }
    
    while(!qu.empty()){
        int i = qu.front().first;
        int p = qu.front().second;
        qu.pop();
        
        if(p==pq.top()){
            pq.pop();
            answer +=1;
            if(i==location){
                break;
            }
        }else{
            qu.push(make_pair(i,p));
        }
    }
    return answer;
}
