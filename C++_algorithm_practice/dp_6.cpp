#include <string>
#include <vector>
#include <cmath>

using namespace std;

int solution(vector<int> money) {
    int answer = 0;
    vector<int> value1(money.size()-1);
    vector<int> value2(money.size());
    
    value1[0] = money[0];
    value1[1] = money[0];
    value2[0] = 0;
    value2[1] = money[1];
    
    for(int i =2;i<value1.size();i++){
        value1[i] = max(value1[i-1],value1[i-2]+money[i]);
    }
    for(int i=2;i<value2.size();i++){
        value2[i] = max(value2[i-1],value2[i-2]+money[i]);
    }
    answer = max(value1[money.size()-2],value2[money.size()-1]);
   
    
    return answer;
}
