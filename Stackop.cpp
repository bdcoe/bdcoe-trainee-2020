#include<stdio.h>
#include<conio.h>
#define n 5

int stack[n], top=-1;

void push();
void pop();
void peek();
void display(); 

int main()
{  
  int ch;
  
   do
  {
  	 printf("Enter choice 0:exit , 1:push , 2:pop, 3:peek, 4:display \n");
     scanf("%d\n",&ch);
     
     switch(ch)
   {
   	
   	case 1: push();
   	        break;
   	        
   	case 2: pop();
   	        break;
   	
   	case 3: peek();
   	        break;
   	        
   	case 4: display();
   	        break;
   	
   	default : printf("Wrong choice\n");
   	
   	
   }  
  
  } while(ch!=0);

}
  
void push()
{   int x;

    printf("Enter item:\n");
    scanf("%d",&x);

	if(top==n-1)
	printf("Overflow");
	
	else {
		   top++;
		   stack[top]=x;
		
	}	
}

void pop()
{
	int item;
	
	if(top==-1)
	printf("Underflow");
	
	else {
		   item=stack[top];
		   top--;
		   printf("Deleted item=%d\n",item);
		   
	}
}


void peek()
{
	if(top==-1)
	printf("Empty\n");
	
	else{
		
		printf("Top element= %d\n",stack[top]);
		
	}
	
}	
	
void display()
{
	int i;
	
	for(i=top; i>=0; i--)
	printf("%d\n",stack[i]);
	
}	
	
	
	
	
	
	
	

 
 
