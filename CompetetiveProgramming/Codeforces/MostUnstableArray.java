
import java.util.*;
import java.util.Collections;

public class MostUnstableArray
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,n,m;
		
		t=sc.nextInt();
		while(t-->0) {
		n=sc.nextInt();
		m=sc.nextInt();
		
		if(n==1)
		System.out.println("0");
		else
			System.out.println(Math.min(2, n-1)*m);
		}
		sc.close();
	}
}

 