#include<bits/stdc++.h>
using namespace std;

bool compare(pair<int,int>a,pair<int,int>b){
	return a.second<b.second;
}
int main() {
	int n;
	cin>>n;
	for(int i=0;i<n;i++){
		int m;
		cin>>m;
		vector<pair<int,int>>v;
		for(int j=0;j<m;j++){
			int a,b;
			cin>>a>>b;
			v.push_back(make_pair(a,b));
		}
		sort(v.begin(),v.end(),compare);
		int count=1;
		for(int j=1;j<m;j++){
			if(v[j].first>=v[j-1].second)
			count++;
		}
		cout<<count<<endl;
	}
	return 0;
}