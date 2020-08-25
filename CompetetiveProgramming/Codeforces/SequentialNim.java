
import java.util.*;
import java.util.Collections;

public class SequentialNim
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,n,i;
		

		t=sc.nextInt();
		while(t-->0) {
			n=sc.nextInt();
		int arr[]=new int[n];
		int count=0;
		for(i=0;i<n;i++) 
			arr[i]=sc.nextInt();
		
		for(i=0;i<n;i++) {
			if(arr[i]!=1)
				break;
			count++;
		}
		if(count==n) {
		if(count%2!=0)
			System.out.println("First");
		else
			System.out.println("Second");
		}
		else {
			if(count%2==0)
				System.out.println("First");
			else
				System.out.println("Second");
		}
		
		}
		sc.close();
	}
}
