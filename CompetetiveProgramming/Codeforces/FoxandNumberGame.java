
import java.util.*;
import java.util.Collections;

public class FoxandNumberGame
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int sum=0,n,i,j,flag=0;
		
		n=sc.nextInt();
		int arr[]=new int[n];
		
		for(i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		while(true) {
		for(i=0;i<n;i++) {
			for(j=0;j<n;j++) {
				if(i==j)
					continue;
				if(arr[j]<arr[i]) 
					arr[i]-=arr[j];
			}
			
		}
		flag=0;
		for(i=0;i<n-1;i++) {
			if(arr[i]!=arr[i+1]) {
				flag=1;break;
			}
		}
		if(flag==0)
			break;
		
		}
		for(i=0;i<n;i++)
			sum+=arr[i];
		System.out.println(sum);

		sc.close();
	}
}
