
import java.util.*;
import java.util.Collections;

public class ChoosingTeams
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int k,n,i,count=0;
		n=sc.nextInt();
		k=sc.nextInt();
		int arr[]=new int[n];
		for ( i = 0; i < arr.length; i++) 
			arr[i]=sc.nextInt()+k;
		
		for ( i = 0; i < arr.length; i++) {
			if(arr[i]<=5)
				count++;
		}
			
		System.out.println(count/3);

		sc.close();
	}
}

