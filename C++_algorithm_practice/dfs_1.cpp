#include <string>
#include <vector>
using namespace std;

void dfs(int,int,int,vector<int>);

int answer = 0;
int solution(vector<int> numbers, int target) {
    dfs(0,0,target,numbers);
    return answer;
}
void dfs(int n,int value,int target,vector<int> numbers){
    if(n==numbers.size()){
        if(value==target){
            answer++;
        }
        return;
    }else{
        dfs(n+1,value+numbers[n],target,numbers);
        dfs(n+1,value-numbers[n],target,numbers);
        
    }
}
