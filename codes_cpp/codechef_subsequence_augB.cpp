#include <bits/stdc++.h>
using namespace std;
# define ll long long
ll compute(map<ll,ll>m){
    int max=INT_MIN,min=INT_MAX;
    for(auto x:m){
        if(x.second>max){
            max=x.second;
        }
    }
    
    for(auto x:m){
        if(x.second==max){
            if(x.first<min){
                min=x.first;
            }
        }
    }
    return min;
}

void find_subsequence(ll *arr,ll n){
    ll actual_array[500001]={0};
    for(ll i=1;i<(1<<n);i++){
        map<ll,ll>m;
        ll a=i;
        ll j=0;
        while(a){
            if(a&1){
            m[arr[j]]++;
            }
            j++;
            a=a>>1;
        }
        ll ans=compute(m);
        actual_array[ans]+=1;
    }
    for(ll i=1;i<=n;i++){
        cout<<actual_array[i]<<" ";
    }
    
}
int main() {
    ll t;
    cin>>t;
    for(ll i=0;i<t;i++){
        ll n;
        cin>>n;
        ll arr[500001]={0};
        for(ll j=0;j<n;j++){
            cin>>arr[j];
        }
        find_subsequence(arr,n);
        cout<<endl;
    }
    return 0;
}