
import java.util.*;
import java.util.Collections;

public class LINCHESS
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,k,n,i,steps,ans=0;
	
		t=sc.nextInt();
		
		while(t-->0) {
		n=sc.nextInt();
		k=sc.nextInt();
		
		int flag=0,temp;
		
		steps=Integer.MAX_VALUE;
		int arr[]=new int[n];
		
		for(i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		for(i=0;i<n;i++) {
			if(k%arr[i]==0) {
				int diff=k-arr[i];
				temp=diff/arr[i];
				if(temp<steps) {
					steps=temp;
					ans=arr[i];
				}
				flag=1;
			}
		}
		if(flag==0)
		System.out.println("-1");
		else
			System.out.println(ans);
		}
		sc.close();
	}
}

