#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

int solution(vector<int> budgets, int M) {
    long answer = 0;
    sort(budgets.begin(),budgets.end());
    long sum = 0;
    for(int d:budgets){
        sum += d;
    }
    if(sum<=M){
        return budgets[budgets.size()-1];
    }
    long max = 100000;
    long min = 1;
    long index;
    while(true){
        long mid = (max+min)/2;
        sum = 0;
        for(int i=0;i<budgets.size();i++){
            if(budgets[i]<mid){
                sum += budgets[i];
            }else{
                sum += mid*(budgets.size() - 1 - (i - 1));
                break;
            }
        }
        if(mid ==index){
            answer = mid;
            break;
        }
        if(sum>M){
            max = mid;
        }else{
            min = mid;
        }
        index = mid;
    }
    return answer;
    
}
