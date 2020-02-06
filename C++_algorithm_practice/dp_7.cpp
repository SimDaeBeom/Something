#include <string>
#include <vector>
#include <cmath>
using namespace std;



int solution(int K, vector<vector<int>> travel) {
    int answer = 0;
    
    int dp[travel.size()+1][100001];
    dp[0][travel[0][0]] = travel[0][1];
    dp[0][travel[0][2]] = travel[0][3];
    for(int i=1;i<travel.size();i++){
        for(int j=1;j<=K;j++){
            if(j+travel[i][0]<=K){
                dp[i][j+travel[i][0]] = max(dp[i][j+travel[i][0]],dp[i-1][j]+travel[i][1]);
                answer = max(answer,dp[i][j+travel[i][0]]);
            }
            if(j+travel[i][2]<=K){
                dp[i][j+travel[i][2]] = max(dp[i][j+travel[i][2]],dp[i-1][j]+travel[i][3]);
                answer = max(answer,dp[i][j+travel[i][2]]);
            }
        }
    }
    return answer;
}
