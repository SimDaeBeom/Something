#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(int distance, vector<int> rocks, int n) {
    int answer = 0;
    sort(rocks.begin(),rocks.end());
    int min = 1;
    int max = distance;
    int mid = (min+max)/2;
    while(min<=max){
        mid = (min+max)/2;
        int remove = 0;
        int idx = -1;
        for(int i=0;i<rocks.size();i++){
            int d = idx ==-1?rocks[i]:i==rocks.size()?distance-rocks.back():rocks[i]-rocks[idx];
            if(d<mid){
                remove++;
            }else{
                idx = i;
            }
        }
        if(remove>n){
            max = mid-1;
        }else{
            min = mid+1;
            answer = answer<mid?mid:answer;
        }
    }
    return answer;
}
