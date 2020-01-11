#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 0;
    int size = 0;
    int max = 0;
    queue<int> qu;

    for(int i=0;i<truck_weights.size();i++){
        size = truck_weights[i];
        while(1){
            if(qu.empty()){
                qu.push(size);
                max +=size;
                answer++;
                break;
            }else if(qu.size()==bridge_length){
                max -= qu.front();
                qu.pop();
                
            }else{
                if(size+max>weight){
                    qu.push(0);
                    answer++;
                }else{
                    qu.push(size);
                    max +=size;
                    answer++;
                    break;
                }
            }
        }
        
    }

    return answer+ bridge_length;
}
