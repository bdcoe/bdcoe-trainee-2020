
import java.util.*;
import java.util.Collections;

public class MaximumInTable
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,temp;
	
		n=sc.nextInt();
		temp=n-2;
		
		if(n==1) {
			System.out.println("1");
			System.exit(0);
		}
		int b[]=new int[n];
		int c[]=new int[n];
		
		for(i=1;i<=n;i++) 
			b[i-1]=i;
		
		while(temp-->0) {
		for(i=1;i<n;i++) {
			c[0]=1;
			c[i]=b[i]+c[i-1];
		}
		for(i=0;i<n;i++)
		 b[i]=c[i];
		}	
		System.out.println(b[n-1]);

		sc.close();
	}
}
