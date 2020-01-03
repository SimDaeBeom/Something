#include <string>
#include <vector>
#include <algorithm>
#include <map>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
   
    map<string, int> participants;
    for (string name: participant) {
        ++participants[name];
    }
    for(string name: completion){
        --participants[name];
    }
    for(auto pair :participants){
        if(pair.second>0){
            return pair.first;
        }
    }
    return 0;
    
}
