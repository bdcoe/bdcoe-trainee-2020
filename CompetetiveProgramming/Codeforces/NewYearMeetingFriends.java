
import java.util.*;
import java.util.Collections;

public class NewYearMeetingFriends
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,n,i,j;
		
		int arr[]=new int[3];
		for(i=0;i<3;i++)
		arr[i]=sc.nextInt();
		Arrays.parallelSort(arr);
		
		System.out.println(arr[1]-arr[0]+arr[2]-arr[1]);

		sc.close();
	}
}

