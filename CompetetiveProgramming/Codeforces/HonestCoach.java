
import java.util.*;
import java.util.Collections;

public class HonestCoach
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,n,i,diff;
		

		t=sc.nextInt();
		
		while(t-->0) {
		n=sc.nextInt();
		int arr[]=new int[n];
		int min=Integer.MAX_VALUE;
		
		for(i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		Arrays.parallelSort(arr);
		for(i=0;i<n-1;i++) {
			diff=arr[i+1]-arr[i];
			if(diff<min)
				min=diff;
		}
		System.out.println(min);
		}
		

		sc.close();
	}
}

