
import java.util.*;
import java.util.Collections;

public class Cifera
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		long n,k,count=0,flag=0;
	
		n=sc.nextLong();
		k=sc.nextLong();
		while(k%n==0) {
			k=k/n;
			count++;
			if(k==1) {
				flag=1;
				break;
			}
		}
		if(flag==1)
			System.out.println("YES\n"+(count-1));
		else
		System.out.println("NO");
		sc.close();
	}
}
