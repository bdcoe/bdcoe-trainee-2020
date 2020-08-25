

import java.util.*;
import java.util.Collections;

public class CheapTravel
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,m,a,b,min;
		int temp1=0,temp2=0,temp=0;

		n=sc.nextInt();
		m=sc.nextInt();
		a=sc.nextInt();
		b=sc.nextInt();
		
		temp1=(n/m)*b+(n%m)*a;
		temp=(n/m)*b+b;
		temp2=a*n;
		
		if(temp<temp1 && temp<temp2) 
			min=temp;
		else if(temp1<temp2)
			min=temp1;
		else
			min=temp2;
		
		System.out.println(min);
		sc.close();
	}
}

