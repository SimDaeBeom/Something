#include <string>
#include <vector>
#include <queue>
using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    int j=0;
    while(j<progresses.size()){
        for(int i=j;i<progresses.size();i++){
            progresses[i] += speeds[i];
        }
        if(progresses[j]>=100){
            queue<int> qu;
            qu.push(progresses[j]);
            for(int i=j+1;i<progresses.size();i++){
                if(progresses[i]>=100){
                    qu.push(progresses[i]);
                    j++;
                }else{
                    break;
                }
            }
            answer.push_back(qu.size());
             j++;
        }
       
    }
    
    return answer;
}
