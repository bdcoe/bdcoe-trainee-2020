#include<stdio.h>
#include<conio.h>
int main()
{
   int a[5],  b[5], c[5] ,i ;
   
   printf("Enter elements in array a\n");
   
   for(i=0; i<5; i++)
   scanf("%d",&a[i]);
   
   printf("Enter elements in array b\n");
   
   for(i=0; i<5; i++)
   scanf("%d",&b[i]);
   
   printf("Arrays before swapping:\n");
   printf("Array a is:\n");
   
   for(i=0; i<5; i++)
   printf("%d\t",a[i]);
   
   printf("\n");
   printf("Array b is:\n");
   
   for(i=0; i<5; i++)
   printf("%d\t",b[i]);
   
   printf("\n");
   
   for(i=0; i<5; i++)
   {
   	c[i]=a[i];
   	a[i]=b[i];
   	b[i]=c[i];
   }
   
   printf("After swapping:\n");
   printf("Array a is:\n");
   
   for(i=0; i<5; i++)
   printf("%d\t",a[i]);
   
   printf("\n");
   printf("Array b is:\n");
   
   for(i=0; i<5; i++)
   printf("%d\t",b[i]);
   
   
   
    
}
   
   
    
   
   
