
import java.util.*;
import java.util.Collections;

public class VasyaandHipster
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int a,b,countp=0,counts=0;

		a=sc.nextInt();
		b=sc.nextInt();
		while(a!=0 && b!=0) {
			a--;
			b--;
			countp++;
		}
			counts+=a/2+b/2;
		System.out.println(countp+" "+counts);
		sc.close();
	}
}

