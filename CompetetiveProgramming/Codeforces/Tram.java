

import java.util.*;
import java.util.Collections;

public class Tram
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,pass,max;
		max=pass=0;
		n=sc.nextInt();
		
		int arr[]=new int[n];
		int b[]=new int[n];
		for(i=0;i<n;i++) {
			arr[i]=sc.nextInt();
			b[i]=sc.nextInt();
		}
		for(i=0;i<n;i++) {
			pass-=arr[i];
			pass+=b[i];
			if(pass>max)
				max=pass;
		}
		
		System.out.println(max);

		sc.close();
	}
}

