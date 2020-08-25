
import java.util.*;
import java.util.Collections;

public class BearandBigBrother
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,n,count=0;
	
		t=sc.nextInt();
		n=sc.nextInt();
		while(t<=n) {
			t*=3;
			n*=2;
			count++;
		}
		System.out.println(count);

		sc.close();
	}
}

