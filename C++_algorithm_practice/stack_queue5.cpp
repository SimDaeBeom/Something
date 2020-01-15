#include <string>
#include <vector>
#include <stack>
using namespace std;

int solution(string arrangement) {
    int answer = 0;
    stack<int> st;
        for(int i=1;i<arrangement.size();i++){
        if(arrangement.at(i-1)=='('&&arrangement.at(i)=='('){
            st.push(0);
        }else if(arrangement.at(i-1)=='('&&arrangement.at(i)==')'&&!st.empty()){
            st.top()++;
        }else if(arrangement.at(i-1)==')'&&arrangement.at(i)==')'){
            int top = st.top();
            st.pop();
            answer += (top+1);
            if(!st.empty()){
              st.top() += top;
            }
        }
    }
    //queue
    return answer;
}
