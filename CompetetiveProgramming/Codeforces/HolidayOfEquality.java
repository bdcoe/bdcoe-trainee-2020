

import java.util.*;
import java.util.Collections;

public class HolidayOfEquality
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,max,count=0;
		

		n=sc.nextInt();
		int arr[]=new int[n];
		
		for(i=0;i<n;i++)
			arr[i]=sc.nextInt();
		Arrays.parallelSort(arr);
		max=arr[n-1];
		for(i=0;i<n;i++) 
			count+=max-arr[i];
		
		
		System.out.println(count);

		sc.close();
	}
}

