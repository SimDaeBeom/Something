#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(vector<int> a ,vector<int> b){
    return a[1]<b[1];
}


int solution(vector<vector<int>> routes) {
    int answer = 0;
    sort(routes.begin(),routes.end(),cmp);
    int limit = -30000;
    for(int i=0;i<routes.size();i++){
        if(limit<routes[i][0]){
            answer++;
            limit= routes[i][1];
        }
    }

    
    return answer;
}
