
import java.util.*;
import java.util.Collections;

public class VasyaandDigitalRoot
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int d,n,i;

		n=sc.nextInt();
		d=sc.nextInt();
		
		if(d==0 && n==1)
		System.out.println(0);
		else if(d==0 && n>1)
			System.out.println("No solution");
		else
		{
			System.out.print(d);
			for(i=1;i<n;i++)
				System.out.print(0);
			System.out.println();
		}

		sc.close();
	}
}
