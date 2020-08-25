
import java.util.*;
import java.util.Collections;

public class CollectingCoins
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,n,i,max;

		t=sc.nextInt();
		while(t-->0) {
		int arr[]=new int[3];
		for(i=0;i<3;i++)
			arr[i]=sc.nextInt();
		int flag=0;
		n=sc.nextInt();
		Arrays.parallelSort(arr);
		max=arr[2];
		for(i=0;i<2;i++) {
			if(arr[i]<max) {
				n-=(max-arr[i]);
				if(n<0) {
				flag=1;
					break;
				}
			}
		}
		if(flag==1 || n%3!=0)
			System.out.println("NO");
		else
			System.out.println("YES");
		
		
		}
		sc.close();
	}
}

