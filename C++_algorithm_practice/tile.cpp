#include <string>
#include <vector>

using namespace std;
int dp(int n);
int solution(int n) {
    int answer = 0;
    int temp[60001];
    temp[1] = 1;
    temp[2] = 2;
    for(int i=3;i<=60000;i++){
        temp[i] = (temp[i-1]+temp[i-2])%1000000007;
    }
    answer = temp[n];
    return answer;
}
