#include <string>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;
//compare 하는 방법 익힐 것!!

bool cmp(const pair<string, int> &a, const pair<string, int> &b)
{
    return a.second > b.second;
}
bool cmp2(const pair<int, int> &a, const pair<int, int> &b)
{
    return a.second > b.second;
}

vector<int> solution(vector<string> genres, vector<int> plays) {
    vector<int> answer;
    map<string,int> count;
    for(int i=0;i<genres.size();i++){
        if(count.find(genres[i])==count.end()){
            // 없으면..
            count[genres[i]] = plays[i];
        }else{
            count[genres[i]] +=plays[i];
        }
    }
    //map to vector 익힐 것!!
    vector<pair<string,int> > vec(count.begin(), count.end());
    sort(vec.begin(),vec.end(),cmp);


    for(auto i = vec.begin();i!= vec.end();i++){
        vector<pair<int,int>> genres_count;
        //index,plays
        for(int j=0;j<genres.size();j++){
            if(genres[j]==i->first){
                genres_count.push_back(make_pair(j, plays[j]));
            }
        }
        sort(genres_count.begin(), genres_count.end(), cmp2);
        answer.push_back(genres_count[0].first);
        if(genres_count.size()>1){
            answer.push_back(genres_count[1].first);
        }
    }
    
    return answer;
}
