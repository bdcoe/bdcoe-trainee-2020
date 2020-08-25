

import java.util.*;
import java.util.Collections;

public class ArrivalOfGeneral
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,min,max,maxp,minp,ans;
		ans=maxp=minp=0;

		n=sc.nextInt();
		int arr[]=new int[n];
		int b[]=new int[n];
		for(i=0;i<n;i++) {
			arr[i]=sc.nextInt();
			b[i]=arr[i];
		}
		
		Arrays.parallelSort(b);
		min=b[0];
		max=b[n-1];
			
		for(i=0;i<n;i++) {
			if(arr[i]==max) {
				maxp=i;
				break;
			}
		}
		for(i=0;i<n;i++) {
			if(arr[i]==min)
				minp=i;
		}
		if(maxp>minp)
			ans=maxp+(n-1-minp)-1;
		else
			ans=maxp+(n-1-minp);
		System.out.println(ans);

		sc.close();
	}
}

