
import java.util.*;
import java.util.Collections;

public class LunchRush
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,f,temp,k,max=Integer.MIN_VALUE;
		int joy=0;
		
		t=sc.nextInt();
		k=sc.nextInt();
		
		while(t-->0) {
			f=sc.nextInt();
			temp=sc.nextInt();
			
			if(temp>k)
				joy=f-(temp-k);
			else
				joy=f;
			
			if(joy>max)
				max=joy;
		}
		
		System.out.println(max);

		sc.close();
	}
}
