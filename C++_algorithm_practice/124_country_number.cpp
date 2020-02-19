#include <string>
#include <vector>
#include <iostream>
using namespace std;
string dp(int n);
string solution(int n) {
    string answer = "";
    answer = dp(n);
    
    
    
    return answer;
}
string dp(int n){
    if(n==1){
        return "1";
    }else if(n==2){
        return "2";
    }else if(n==3){
        return "4";
    }
    if(n%3!=0)
        return dp(n/3)+dp(n%3);
    else{
        return dp((n-1)/3)+dp(3);
    }
}
