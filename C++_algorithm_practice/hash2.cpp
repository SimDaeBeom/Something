#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

bool solution(vector<string> phone_book) {
    bool answer = true;
    sort(phone_book.begin(),phone_book.end());
    for(int i=0;i<phone_book.size()-1;i++){
        string head = phone_book[i];
            if(head==phone_book[i+1].substr(0,head.size())){
                return false;
            }
    
    }
    return answer;
}
