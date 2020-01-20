#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    priority_queue<int,vector<int>,greater<int>> pq;
    for(int i=0;i<scoville.size();i++)
        pq.push(scoville[i]);
    while(true){
        if(pq.top()<K&&pq.size()>1){
            int a = pq.top();
            pq.pop();
            int b = pq.top();
            pq.pop();
            pq.push(a+(2*b));
            answer++;
        }else{
            if(pq.top()<K&&pq.size()<=1){
                return -1;
            }
            break;
        }
    }
    
    return answer;
}
