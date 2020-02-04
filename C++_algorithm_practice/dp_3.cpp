#include <string>
#include <vector>
#include <algorithm>

using namespace std;


int solution(vector<vector<int>> triangle) {
    int answer = 0;
    for(int i=1;i<triangle.size();i++){
        for(int j=0;j<triangle[i].size();j++){
            triangle[i][j] += triangle[i-1][j-1]>triangle[i-1][j]?triangle[i-1][j-1]:
            triangle[i-1][j];
        }
    }
    vector<int> temp = triangle[triangle.size()-1];
    answer = *max_element(temp.begin(),temp.end());
    return answer;
}

