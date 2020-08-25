
import java.util.*;
import java.util.Collections;

public class GeorgeandAccomodation
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,j;
		int count=0;

		n=sc.nextInt();
		while(n-->0) {
			i=sc.nextInt();
			j=sc.nextInt();
			if(j-i>=2)
				count++;
		}
		
		System.out.println(count);

		sc.close();
	}
}

