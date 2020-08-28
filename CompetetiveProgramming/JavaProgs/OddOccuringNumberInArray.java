
import java.util.*;
import java.util.Collections;

public class OddOccuringNumberInArray
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,ans=0;
	

		n=sc.nextInt();
		int arr[]=new int[n];
		
		for(i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		for(i=0;i<n;i++) {
			ans=ans^arr[i];
		}
		
		System.out.println(ans);

		sc.close();
	}
}

