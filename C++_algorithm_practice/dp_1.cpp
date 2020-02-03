#include <string>
#include <vector>

using namespace std;

int answer = 1000;
int number_,N_;
void dp(int,int);
int solution(int N, int number) {
    number_ = number;
    N_ = N;
    dp(0,0);
    if(answer>8){
        return -1;
    }
    return answer;
}
void dp(int n,int count){
    if(count >8){
        return;
    }else{
        int temp = 0;
        if(n==number_&&answer>count){
            answer = count;
        }else{
            for(int i=0;i<8;i++){
                temp =10*temp+N_;
                dp(temp+n,count+i+1);
                dp(temp-n,count+i+1);
                dp(temp*n,count+i+1);
                if(n!=0){
                    dp(temp/N_,count+i+1);
                }
                dp(n/temp,count+i+1);
                dp(n-temp,count+i+1);
            }
        }
    }
}

