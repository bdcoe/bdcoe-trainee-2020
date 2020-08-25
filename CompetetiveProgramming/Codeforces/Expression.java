
import java.util.*;
import java.util.Collections;

public class Expression
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int a,b,c,max=0;

		a=sc.nextInt();
		b=sc.nextInt();
		c=sc.nextInt();
		
		if(a+b*c>max)
			max=a+b*c;
		if(a*(b+c)>max)
			max=a*(b+c);
		if(a*b*c>max)
			max=a*b*c;
		if((a+b)*c>max)
			max=(a+b)*c;
		if(a+b+c>max)
			max=a+b+c;
		if((a*b)+c>max)
			max=(a*b)+c;
		
		System.out.println(max);

		sc.close();
	}
}

