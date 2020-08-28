#include<bits/stdc++.h>
using namespace std;
int a[100];
int fib(int n)
{
	if(a[n]==-1){
		a[n]=fib(n-1)+fib(n-2);
		
	}
	return a[n];
}
int main()
{

 int n;
 cin>>n;
 return fib(n);
}
