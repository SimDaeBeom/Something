#include <string>
#include <vector>

using namespace std;

vector<vector<int>> answer;
void execute(int front, int mid, int back,int n);
vector<vector<int>> solution(int n) {
 
    execute(1, 2, 3, n);
    return answer;
}
void execute(int front, int mid, int back,int n)
{
    if(n==0){
        return;
    }else{
        execute(front, back, mid, n-1);
        vector<int> temp;
        temp.push_back(front);
        temp.push_back(back);
        answer.push_back(temp);
        execute(mid, front, back, n-1);
    }
}
