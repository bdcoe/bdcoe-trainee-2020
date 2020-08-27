#include <bits/stdc++.h>
using namespace std;
int karPaye(int* arr,int n,int k,int capacity){
    int m=n-1;
    while(k>0 && m>=0){
        if(arr[m]<=capacity){
            k--;
            m--;
        }
        else{
            return 0;
        }
    }
    if(m>=0)
    return 0;
    return 1;
}
int paintIt(int*arr,int n,int k,int t){
    int s=0,e=1000000,ans=0;
    while(s<=e){
        int mid=(s+e)/2;
        int eachPainterCapacity=mid/t;
        if(karPaye(arr,n,k,eachPainterCapacity)){
            ans=mid;
            e=mid-1;
        }
        else{
            s=mid+1;
        }
    }
    return ans % 10000003;
}
int main() {
    int n,k,t;
    cin>>n>>k>>t;
    int arr[100000];
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    sort(arr,arr+n);
    cout<<paintIt(arr,n,k,t);
    return 0;
}
