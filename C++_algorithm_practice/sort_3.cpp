#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

int solution(vector<int> citations) {
    int answer = 0;
    vector<int> ct= citations;
    sort(ct.begin(),ct.end(),greater<int>());
    for(int i=0;i<ct.size();i++){
        if(i+1>ct[i]){
            return i;
        }
        
        
    }
    return citations.size();
}
