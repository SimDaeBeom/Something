#include <string>
#include <vector>
#include <unordered_map>


using namespace std;

int solution(vector<vector<string>> clothes) {
    int answer = 0;
    unordered_map<string,int> looks;
    for(vector<string> look:clothes){
        if(looks.find(look[1])==looks.end()){
            looks[look[1]] = 1;
        }else{
            ++looks[look[1]];
        }
    }
    
    int temp = 1;
    unordered_map<string, int>::iterator iter;
    for(iter=looks.begin();iter !=looks.end();iter++){
        temp *= iter->second+1;
    }
    answer = temp-1;
    return answer;
    
}
