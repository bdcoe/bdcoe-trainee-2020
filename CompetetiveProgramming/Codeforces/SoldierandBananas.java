

import java.util.*;
import java.util.Collections;

public class SoldierandBananas
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int i,n,k,w;
		long sum=0;
		k=sc.nextInt();
		n=sc.nextInt();
		w=sc.nextInt();
		for(i=1;i<=w;i++)
			sum+=k*i;
		if(sum>=n)
		System.out.println(sum-n);
		else
			System.out.println("0");

		sc.close();
	}
}