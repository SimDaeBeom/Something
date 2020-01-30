#include <string>
#include <vector>
using namespace std;

int solution(vector<vector<int>> baseball) {
    int answer = 0;
    for(int i=123;i<=987;i++){
        int hun = i/100;
        int ten = (i/10)%10;
        int one = i%10;
        if(hun!=ten&&hun!=one&&ten!=one&&hun*ten*one!=0){
            bool isValue = false;
            for(int j=0;j<baseball.size();j++){
                int strike = 0;
                int ball = 0;
                if(baseball[j][0]/100==hun){
                    strike++;
                }else if(baseball[j][0]/100==ten||baseball[j][0]/100==one){
                    ball++;
                }
                if((baseball[j][0]/10)%10==ten){
                    strike++;
                }else if((baseball[j][0]/10)%10==one||(baseball[j][0]/10)%10==hun){
                    ball++;
                }
                if(baseball[j][0]%10==one){
                    strike++;
                }else if(baseball[j][0]%10==hun||baseball[j][0]%10==ten){
                    ball++;
                }
                if(strike==baseball[j][1]&&ball==baseball[j][2]){
                    isValue = true;
                }else{
                    isValue = false;
                    break;
                }
            }
            if(isValue){
                answer++;
            }
            
        }
    }
    
    
    return answer;
}
