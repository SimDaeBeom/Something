#include <string>
#include <vector>

using namespace std;

vector<int> solution(int brown, int red) {
    vector<int> answer;
//    red  = a*b;
//    brown (a+2)*(b+2)-ab = ab +2a+2b+4-ab = 2a+ 2b+4;
    for(int row=1;row<=red;row++){
        if(red%row==0){
            int col = red/row;
            if(brown ==(2*row+2*col+4)){
                if(row>=col){
                    answer.push_back(row+2);
                    answer.push_back(col+2);
                }else{
                    answer.push_back(col+2);
                    answer.push_back(row+2);
                }
                break;
            }
        }
    }
    return answer;
}
