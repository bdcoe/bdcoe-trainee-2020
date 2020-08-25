
import java.util.*;
import java.util.Collections;

public class CHEFSTR1
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,n,i;
		
		t=sc.nextInt();
		
		while(t-->0) {
			n=sc.nextInt();
			int arr[]=new int[n];
			long ans=0;
			
			
			for(i=0;i<n;i++)
				arr[i]=sc.nextInt();
			
			for(i=0;i<n-1;i++) 
				ans+=(int)Math.abs(arr[i+1]-arr[i])-1;
			
			System.out.println(ans);
		}

		sc.close();
	}
}

