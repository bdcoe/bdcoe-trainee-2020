
import java.util.*;
import java.util.Collections;

public class MAgicalSticks_654
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t;
		long n,i,j;
		double ans;

		t=sc.nextInt();
		
		while(t-->0) {
		
			n=sc.nextLong();
			ans=Math.ceil(n/2.0);
			System.out.println((long)ans);
			}
		sc.close();
	}
}

