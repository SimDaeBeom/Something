#include <string>
#include <vector>
using namespace std;

int solution(int m, int n, vector<vector<int>> puddles) {
    int answer = 0;
    vector<vector<int>> temp(n+1,vector<int>(m+1));
    for(int i=0;i<n+1;i++){
        temp[i][1] = 1;
    }
    for(int j=1;j<m+1;j++){
        temp[1][j] = 1;
    }
    for(int i=0;i<puddles.size();i++){
        temp[puddles[i][1]][puddles[i][0]] = -1;
    }
    
    
    for(int i=1;i<n+1;i++){
        for(int j=1;j<m+1;j++)
            if(temp[i][j]!=-1){
                temp[i][j] = (temp[i-1][j] + temp[i][j-1])%1000000007;
            }else{
                temp[i][j] = 0;
            }
    }
    
    answer = temp[n][m];
    return answer;
}
