
import java.util.*;
import java.util.Collections;

public class BalancedArray
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int ev,od,t,n,i,j,flag=0;
		ev=2;od=1;
		t=sc.nextInt();
		while(t-->0) {
			n=sc.nextInt();
			int arr[]=new int[n];
			if(n%4!=0) 
				flag=1;
			if(flag!=1) {
			for(i=0;i<n/2;i++) {
				arr[i]=ev;
				ev+=2;
			}
			for(i=n/2;i<n;i++) {
				arr[i]=od;
				od+=2;
				if(i==n-1)
					arr[n-1]=n-1+n/2;
			}
			}
			if(flag==1)
				System.out.println("NO");
			else {
				System.out.println("YES");
				for(int item: arr)
					System.out.print(item+" ");
				System.out.println();
			}
			ev=2;od=1;flag=0;
		}
		

		sc.close();
	}
}

