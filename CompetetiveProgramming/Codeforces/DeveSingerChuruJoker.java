
import java.util.*;
import java.util.Collections;

public class DeveSingerChuruJoker
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,n,i,tempt1=0;

		n=sc.nextInt();
		t=sc.nextInt();
		int arr[]=new int[n];
		
		for(i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		for(i=0;i<n;i++)
			tempt1+=arr[i];
		
		
		if(tempt1+(n-1)*10>t)
			System.out.println("-1");
		else
			System.out.println((t-tempt1)/5);

		sc.close();
	}
}

