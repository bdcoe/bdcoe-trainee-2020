
import java.util.*;
import java.util.Collections;

public class WrongSubtraction
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,k;

		n=sc.nextInt();
		k=sc.nextInt();
		while(k-->0) {
			if(n%10==0)
				n/=10;
			else
				n--;
		}
		
		System.out.println(n);

		sc.close();
	}
}

