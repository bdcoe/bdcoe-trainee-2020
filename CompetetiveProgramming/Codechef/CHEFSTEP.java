
import java.util.*;
import java.util.Collections;

public class CHEFSTEP
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,n,i,k;
		

		t=sc.nextInt();
		while(t-->0) {
		n=sc.nextInt();
		k=sc.nextInt();
		String s="";
		int arr[]=new int[n];
			
		for(i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		for(i=0;i<n;i++) {
			if(arr[i]%k==0)
				s=s+"1";
			else
				s=s+"0";
		}
		System.out.println(s);
			
		}
		

		sc.close();
	}
}

