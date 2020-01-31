
//조이스틱 문제 -> greedy 2번인데 3번으로 품.
#include <string>
#include <vector>
using namespace std;

int solution(string name) {
    int answer1 = 0;
    int answer2 = 0;
    int answer3 = 0;
    int answer =0;
    string temp1 ="";
    string temp2 ="";
    string temp3 ="";
    
    for(int i=0;i<name.size();i++){
        temp1 +="A";
        temp2 +="A";
        temp3 +="A";
    }
    
    //왼쪽으로
    for(int i=0;i<name.size();i++){
        if(temp1==name){
            break;
        }
        if(temp1[i]!=name[i]){
            int value = name[i]-'N'>=0?'Z'-name[i]+1:name[i]-'A';
            temp1[i] = name[i];
            answer1 += value;
            
        }
        if(temp1!=name){
            answer1++;
        }
    }
    //오른쪽
    answer2 = name[0]-'N'>=0?'Z'-name[0]+1:name[0]-'A';
    temp2[0] = name[0];
    if(temp2!=name){
        answer2++;
    }
    for(int i=name.size()-1;i>0;i--){
        if(temp2==name){
            break;
        }
        if(temp2[i]!=name[i]){
            int value = name[i]-'N'>=0?'Z'-name[i]+1:name[i]-'A';
            temp2[i] = name[i];
            answer2 += value;
        }
        if(temp2!=name){
            answer2++;
        }
    }
    
    
    //왔다갔다.
    //이부분 어거지로 푼듯.
    
    int j = 0;
    for(int i=0;i<name.size();i++){
        if(temp3==name){
            break;
        }
        string sample = name.substr(i,name.size()/2);
        string sample2 = "";
        for(int i=0;i<sample.size();i++){
            sample2 +="A";
        }
        if(sample==sample2){
            j=i-1;
            break;
        }
        if(temp3[i]!=name[i]){
            int value = name[i]-'N'>=0?'Z'-name[i]+1:name[i]-'A';
            temp3[i] = name[i];
            answer3 += value;
            
        }
        
        if(temp3!=name){
            answer3++;
        }
    }
    
    for(int i=j-1;i>=0;i--){
        if(temp3==name){
            break;
        }
        if(temp3[i]!=name[i]){
            int value = name[i]-'N'>=0?'Z'-name[i]+1:name[i]-'A';
            temp3[i] = name[i];
            answer3 += value;
        }
        if(temp3!=name){
            answer3++;
        }
    }
    for(int i=name.size()-1;i>j;i--){
        if(temp3==name){
            break;
        }
        if(temp3[i]!=name[i]){
            int value = name[i]-'N'>=0?'Z'-name[i]+1:name[i]-'A';
            temp3[i] = name[i];
            answer3 += value;
        }
        if(temp3!=name){
            answer3++;
        }
    }
    
    answer  = answer1>answer2?answer2:answer1;
    answer  = answer>answer3?answer3:answer;
    return answer;
}
