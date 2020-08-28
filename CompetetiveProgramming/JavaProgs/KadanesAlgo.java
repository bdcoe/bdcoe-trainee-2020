/*
 * MAXIMUM SUM SUBARRAY USING KADANES ALGORITHM
 * */
import java.util.*;
import java.util.Collections;

public class KadanesAlgo
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i;

		n=sc.nextInt();
		int arr[]=new int[n];
		
		for(i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		int count=0;
		int res=Integer.MIN_VALUE;
		
		for(i=0;i<n;i++) {
			count+=arr[i];
			res=Math.max(count, res);
			
			if(count<0)
				count=0;
		}
		
		System.out.println(res);

		sc.close();
	}
}
