#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a[100],i,j,n,swap;
    printf("Enter the size of array");
    scanf("%d",&n);
    printf("Enter %d integers of array",n);
    for(i=0;i<n;i++)
    {
        scanf("%d",&a[i]);
    }
    for(i=0;i<n-1;i++){
        for(j=0;j<n-i-1;j++){
            if(a[j]>a[j+1]){
                swap=a[j];
                a[j]=a[j+1];
                a[j+1]=swap;
            }
        }
    }
    printf("Sortlist in ascending order is \n");
    for(i=0;i<n;i++)
    {
        printf("%d\n",a[i]);
    }
    return 0;
}
