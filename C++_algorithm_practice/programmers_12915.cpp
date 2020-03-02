#include <string>
#include <vector>
#include <algorithm>
using namespace std;


bool cmp(string a,string b);
int temp;
vector<string> solution(vector<string> strings, int n) {
    vector<string> answer;
    temp= n;
    sort(strings.begin(),strings.end(),cmp);
    answer = strings;
    return answer;
}
bool cmp(string a,string b){
    if(a[temp]==b[temp]){
        return a<b;
    }else{
        return a[temp]<b[temp];
        
    }
}


