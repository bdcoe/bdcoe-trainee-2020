#include<bits/stdc++.h>
using namespace std;
void find_duplicate(string s){
	int plus_count=0;
	int parenthesis_count=0;
	for(int i=0;s[i]!='\0';i++){
		if(s[i]=='('){
			parenthesis_count++;
		}
		else if(s[i]==')'){
			parenthesis_count--;
			if(s[i-2]!='('){
				plus_count--;
			}
		}
		else if(!(s[i]>=97 && s[i]<=122)){
			plus_count++;
		}
	}
	if(plus_count==parenthesis_count){
		cout<<"Not Duplicates"<<endl;
	}
	else{
		cout<<"Duplicate"<<endl;
	}
}
int main() {
	int t;
	cin>>t;
	for(int i=0;i<t;i++){
		string s;
		cin>>s;
		find_duplicate(s);
	}
	return 0;
}