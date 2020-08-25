
import java.util.*;
import java.util.Collections;

public class Domino
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,sum1=0,sum2=0,flag=0;
		n=sc.nextInt();
		int arr[]=new int[n];
		int b[]=new int[n];
		
		for(i=0;i<n;i++) {
			arr[i]=sc.nextInt();
			sum1+=arr[i];
			b[i]=sc.nextInt();
			sum2+=b[i];
		}
		
		if(sum1%2==0 && sum2%2==0)
			System.out.println(0);
		else {
			if(sum1%2==0 && sum2%2!=0 || sum1%2!=0 && sum2%2==0)
				System.out.println(-1);
			if(sum1%2!=0 && sum2%2!=0) {
				for(i=0;i<n;i++) {
					if(arr[i]%2==0 && b[i]%2!=0 || arr[i]%2!=0 && b[i]%2==0) {
						flag=1;
						break;
					}
				}
				if(flag==1)
					System.out.println(1);
				else
					System.out.println(-1);
			}
		}
	
	
		sc.close();
	}
}
