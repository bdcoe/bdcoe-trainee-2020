
import java.util.*;
import java.util.Collections;

public class ILoveUsername
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,min=0,max=0,count=1;

		n=sc.nextInt();
		int arr[]=new int[n];
		
		for(i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		if(arr.length==1) {
			System.out.println("0");
			System.exit(0);
		}
		
		if(arr[1]>arr[0]) {
			max=arr[1];
			min=arr[0];
		}
		if(arr[0]>arr[1]) {
			max=arr[0];
			min=arr[1];
		}
		if(arr[0]==arr[1]) {
			max=arr[0];
			min=arr[1];
			count=0;
		}
		
		for(i=2;i<n;i++) {
			if(arr[i]>max) {
				max=arr[i];count++;
			}
			if(arr[i]<min) {
				min=arr[i];
				count++;
			}
		}
		
		System.out.println(count);

		sc.close();
	}
}

