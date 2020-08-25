

import java.util.*;
import java.util.Collections;

public class Drinks
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,j;
		double sum=0.0;
		double ans;
		n=sc.nextInt();
		int arr[]=new int[n];
		for(i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		for(i=0;i<n;i++)
			sum+=arr[i];
		
		ans=sum/n;
		System.out.println(ans);

		sc.close();
	}
}

