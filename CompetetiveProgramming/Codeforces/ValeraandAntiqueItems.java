

import java.util.*;
import java.util.Collections;

public class ValeraandAntiqueItems
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,v,k,n,i,count=0,flag=0;
		int	c=0;
		t=sc.nextInt();
		v=sc.nextInt();
		int b[]=new int[t];
		for(k=1;k<=t;k++) {
		n=sc.nextInt();	
		flag=0;
		int arr[]=new int[n];
		
		for(i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		for(i=0;i<n;i++) {
			if(arr[i]<v) { 
				flag=1;
				break;
			}
			}
		
		if(flag==1) {
			count++;
			b[c]=k;
			c++;
		}
			
		}
		
		if(count!=0) {
		System.out.println(count);
		for(i=0;i<t;i++) {
			if(b[i]!=0)
				System.out.print(b[i]+" ");
		}
		}
		else
			System.out.println(0);
		sc.close();
	}
}

