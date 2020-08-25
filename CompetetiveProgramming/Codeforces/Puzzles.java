
import java.util.*;
import java.util.Collections;

public class Puzzles
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int m,n,i,min=Integer.MAX_VALUE;
		

		n=sc.nextInt();
		m=sc.nextInt();
		
		int arr[]=new int[m];
		
		for(i=0;i<m;i++)
			arr[i]=sc.nextInt();
		
		Arrays.sort(arr);
		
		for(i=0;i<=m-n;i++) {
			if(arr[i+n-1]-arr[i]<min)
				min=arr[i+n-1]-arr[i];
		}
		
		System.out.println(min);

		sc.close();
	}
}
