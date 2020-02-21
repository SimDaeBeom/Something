#include <string>
#include <vector>

using namespace std;

string solution(int a, int b) {
    string answer = "";
    string days[7] = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
    int total_days_of_months[12] = {31,29,31,30,31,30,31,31,30,31,30,31};
    int day = -1;
    
    for(int i=0;i<a-1;i++){
        day+=total_days_of_months[i];
    }
    day+=b;
    answer = days[(5+day)%7];
    
    return answer;
}


