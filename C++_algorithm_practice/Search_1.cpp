#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    
    vector<int> answer1 = {1,2,3,4,5};
    vector<int> answer2 = {2,1,2,3,2,4,2,5};
    vector<int> answer3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    vector<int> value(3);
    for(int i=0;i<answers.size();i++){
        
        if(answer1[i%answer1.size()]==answers[i]){
            value[0] ++;
        }
        if(answer2[i%answer2.size()]==answers[i]){
            value[1] ++;
        }
        if(answer3[i%answer3.size()]==answers[i]){
            value[2] ++;
        }
    }
    int max = *max_element(value.begin(),value.end());
    for(int i=0;i<value.size();i++){
        if(value[i]==max){
            answer.push_back(i+1);

        }
    }

    return answer;
}
