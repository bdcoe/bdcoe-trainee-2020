
import java.util.*;
import java.util.Collections;

public class CounterExample
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		long l,r;
		l=sc.nextLong();
		r=sc.nextLong();
		
		
		if(l%2!=0)
			l++;
		
		if((l+2)>r)
			System.out.println("-1");
		else
			System.out.println(l+" "+(l+1)+" "+(l+2));

		sc.close();
	}
}

