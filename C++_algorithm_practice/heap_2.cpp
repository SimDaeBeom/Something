#include <string>
#include <vector>
#include <queue>
using namespace std;

int solution(int stock, vector<int> dates, vector<int> supplies, int k) {
    priority_queue<int,vector<int>,less<int>> pq;
    int date = 0;
    int i = 0;
    int answer =0;
    
    while(stock<k-date){
        stock--;
        date++;
        while(true){
            if(date >= dates[i]){
                pq.push(supplies[i]);
                i++;
            }else{
                break;
            }
        }
        if(stock==0&&date<k){
            stock+=pq.top();
            pq.pop();
            answer++;
        }
        
    }
    
    
    return answer;
}
