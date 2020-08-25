
import java.util.*;
import java.util.Collections;

public class TL
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,j,m,l,r,flag=0;
		
		n=sc.nextInt();
		m=sc.nextInt();
		
		int arr[]=new int[n];
		int b[]=new int[m];
		
		for(i=0;i<n;i++) 
			arr[i]=sc.nextInt();
		
		for(i=0;i<m;i++) 
			b[i]=sc.nextInt();
		
		Arrays.parallelSort(arr);
		Arrays.parallelSort(b);
		l=arr[n-1];
		r=b[0];
		
		for(i=l;i<r;i++) {
			for(j=0;j<n;j++) {
				if(arr[j]*2<=i) {
					flag=1;
					break;
				}
			}
			if(flag==1)
				break;
		}
		if(flag==1)
		System.out.println(i);
		else
			System.out.println("-1");
		
		sc.close();
	}
}
