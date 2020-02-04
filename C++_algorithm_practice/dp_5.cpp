#include <string>
#include <vector>
#include <algorithm>
#include <cmath>
#include <iostream>
using namespace std;
int answer = 0;
void dp(vector<int>,vector<int>,int);
int solution(vector<int> left, vector<int> right) {
    
    if(*max_element(left.begin(),left.end())>*max_element(right.begin(), right.end())){
        for(int i=0;i<right.size();i++){
            answer +=right[i];
        }
        return answer;
    }else{
        vector<vector<int>> temp(left.size()+1,vector<int>(right.size()+1,0));
        for(int i=0;i<=right.size();i++){
            temp[0][i] = -1;
        }
        for(int i=0;i<=left.size();i++){
            for(int j=0;j<=right.size();j++){
                cout<<temp[i][j]<<" ";
                
            }
            cout<<endl;
        }
        for(int i=1;i<=left.size();i++){
            for(int j=1;j<=right.size();j++){
                temp[i][j] = temp[i-1][j]>temp[i-1][j-1]? temp[i-1][j]:temp[i-1][j-1];
                if(temp[i][j-1]!=-1&&left[i-1]>right[j-1]){
                    temp[i][j] = temp[i][j-1]+right[j-1];
                }
            }
        }
        answer = temp[left.size()][right.size()];
        return answer;
        }
}

