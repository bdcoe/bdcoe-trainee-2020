
import java.util.*;
import java.util.Collections;

public class GiftsFixing_661
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);


		int t,n,i,minarr,minb;
		
		t=sc.nextInt();
		while(t-->0) {
		n=sc.nextInt();
		long count=0;
			int arr[]=new int[n];
			int b[]=new int[n];
			
			for(i=0;i<n;i++)
				arr[i]=sc.nextInt();
			
			for(i=0;i<n;i++)
				b[i]=sc.nextInt();
			
		minarr=arr[0];
		minb=b[0];
			
		for(i=0;i<n;i++) {
			if(arr[i]<minarr)
				minarr=arr[i];
			if(b[i]<minb)
				minb=b[i];
		}
			
		for(i=0;i<n;i++) {
				if((arr[i]-minarr)<(b[i]-minb)) {
					count+=arr[i]-minarr;
					b[i]-=arr[i]-minarr;
					count+=b[i]-minb;
					continue;
			}
				if((arr[i]-minarr)>(b[i]-minb)) {
					count+=b[i]-minb;
					arr[i]-=b[i]-minb;
					count+=arr[i]-minarr;
					continue;
			}
				if((arr[i]-minarr)==(b[i]-minb)) {
					count+=arr[i]-minarr;
				}
		}
		System.out.println(count);
		
		}

		sc.close();
	}
}
