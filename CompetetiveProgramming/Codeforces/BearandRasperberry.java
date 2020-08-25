
import java.util.*;
import java.util.Collections;

public class BearandRasperberry
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int r,n,i;

		n=sc.nextInt();
		r=sc.nextInt();
		
		int arr[]=new int[n];
		int b[]=new int[n-1];
		
		for(i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		for(i=0;i<n-1;i++) {
			b[i]=arr[i]-arr[i+1];
		}
		
		Arrays.parallelSort(b);
		if(b[n-2]>0 && (b[n-2]-r)>0)
		System.out.println(b[n-2]-r);
		else
			System.out.println("0");

		sc.close();
	}
}

