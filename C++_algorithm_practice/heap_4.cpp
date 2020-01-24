#include <string>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

vector<int> solution(vector<string> operations) {
    vector<int> answer;
    deque<int> dq;
    for(int i=0;i<operations.size();i++){
        if(operations[i]=="D 1"){
            if(!dq.empty())
                dq.pop_back();
        }else if(operations[i]=="D -1"){
            if(!dq.empty())
                dq.pop_front();
        }else{
            string num = operations[i].substr(2);
            int number = atoi(num.c_str());
            dq.push_back(number);
            sort(dq.begin(), dq.end());
        }
    }
    
    if(!dq.empty()){
        answer.push_back(dq.back());
        answer.push_back(dq.front());
    }else{
        answer.push_back(0);
        answer.push_back(0);
    }
    return answer;
}
