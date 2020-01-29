#include <string>
#include <vector>
#include <algorithm>
#include <math.h>
using namespace std;

bool check_prime(int);
bool check_value(string,int[]);
int solution(string numbers) {
    int answer = 0;
    int count[10]={0,};
    for(int i=0;i<numbers.size();i++){
        count[numbers[i]-'0']++;
    }
    sort(numbers.begin(),numbers.end(),greater<int>());
    for(int i=2;i<=atoi(numbers.c_str());i++){
        if(check_prime(i)&&check_value(to_string(i),count)){
            answer++;
        }
    }
    return answer;
}

bool check_prime(int number){
    for(int i=2;i<=sqrt(number);i++){
        if(number%i==0){
            return false;
        }
    }
    return true;
}

bool check_value(string number,int count[]){
    int ct[10];
    copy(count, count+10, ct);
    for(int i=0;i<number.size();i++){
        if(ct[number[i]-'0']==0){
            return false;
            
        }else{
            ct[number[i]-'0']--;
        }
    }
    return true;
    
}
