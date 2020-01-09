#include <string>
#include <vector>
#include <stack>
using namespace std;

vector<int> solution(vector<int> heights) {
    vector<int> answer;
    answer.push_back(0);
    for(int i=1;i<heights.size();i++){
        stack<int> st;
        int top = heights[i];
        for(int j=0;j<i;j++){
            st.push(heights[j]);
        }
        while(true){
            if(st.empty()){
                answer.push_back(0);
                break;
            }
            if(top<st.top()){
                answer.push_back(st.size());
                break;
            }else{
                st.pop();
                
            }
        }
    }
    
    
    
    return answer;
}
