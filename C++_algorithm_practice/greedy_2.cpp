#include <string>
#include <vector>
#include <algorithm>
#include <stack>

using namespace std;

string solution(string number, int k) {
    string answer = "";
    stack<int> st;
    int size = number.size()-k;
    for(int i=0;i<number.size();i++){
        
        while(!st.empty()&&k>0){
            if(st.top()>=number[i]-'0'){
                break;
            }
            st.pop();
            k--;
        }
        st.push(number[i]-'0');
    }
    while(size!=st.size()){
        st.pop();
    }
    while(!st.empty()){
        answer = to_string(st.top()) +answer;
        st.pop();
    }
    
    return answer;
    
}
