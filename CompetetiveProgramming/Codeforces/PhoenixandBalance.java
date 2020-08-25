
import java.util.*;
import java.util.Collections;

public class PhoenixandBalance
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,n,i;
		long sum1,sum2;
		t=sc.nextInt();
		
		
		while(t-->0) {
		n=sc.nextInt();
		sum1=(long)Math.pow(2,n);
		sum2=0;
		for(i=1;i<n/2;i++)
			sum1+=(long)Math.pow(2,i);
		
		for(i=n/2;i<n;i++)
			sum2+=(long)Math.pow(2,i);
		System.out.println(sum1-sum2);
		
		}
		sc.close();
	}
}

