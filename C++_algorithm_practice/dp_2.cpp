#include <string>
#include <vector>

using namespace std;


long long solution(int N) {
    long a = 1;
    long b = 2;
    long long answer = 4;

    if(N==1){
        return answer;
    }else{
        for(int i=2;i<=N;i++){
            answer += a*2;
            long temp = b;
            b = a + b;
            a =  temp;
            
        }
    }
    return answer;
}

