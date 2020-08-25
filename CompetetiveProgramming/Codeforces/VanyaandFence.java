
import java.util.*;
import java.util.Collections;

public class VanyaandFence
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,h,count;
		count=0;
		n=sc.nextInt();
		h=sc.nextInt();
		
		int arr[]=new int[n];
		for(i=0;i<n;i++)
			arr[i]=sc.nextInt();
		for(i=0;i<n;i++) {
			if(arr[i]>h)
				count+=2;
			else
				count++;
		}
		
		System.out.println(count);

		sc.close();
	}
}

