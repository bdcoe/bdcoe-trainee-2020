

import java.util.*;
import java.util.Collections;

public class EvenArray
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,n,i;

		t=sc.nextInt();
		while(t-->0) {
			n=sc.nextInt();
		int arr[]=new int[n];
		int count=0,odd=0,even=0;
		
		for(i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		for(i=0;i<n;i++) {
			if(i%2!=arr[i]%2) {
				if(arr[i]%2==0)
					even++;
				else
					odd++;
				count++;
		}
		}
		
		if(count%2!=0 || even!=count/2 || odd!=count/2)
			System.out.println("-1");
		else {
			System.out.println(count/2);
		}
		}
		

		sc.close();
	}
}
