

import java.util.*;
import java.util.Collections;

public class Magnets
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,count;
		count=0;
		
		n=sc.nextInt();
		int arr[]=new int[n];
		
		for(i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		for(i=0;i<n-1;i++) {
			if(arr[i+1]!=arr[i])
				count++;
		}
		
		System.out.println(count+1);

		sc.close();
	}
}

