
import java.util.*;
import java.util.Collections;

public class Laptops
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,flag=0;
		t=sc.nextInt();
		int a,b;
		while(t-->0) {
			a=sc.nextInt();
			b=sc.nextInt();
			if(a!=b) {
				flag=1;break;
			}
		}
		
		if(flag==1)
		System.out.println("Happy Alex");
		else
			System.out.println("Poor Alex");

		sc.close();
	}
}

