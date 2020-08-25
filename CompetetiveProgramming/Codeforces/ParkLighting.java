
import java.util.*;
import java.util.Collections;

public class ParkLighting
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,m,n,i;
		
		t=sc.nextInt();
		while(t-->0) {
		n=sc.nextInt();
		m=sc.nextInt();
		i=n*m;
		System.out.println((int)Math.ceil(i/2.0));
		}
		
		

		sc.close();
	}
}

