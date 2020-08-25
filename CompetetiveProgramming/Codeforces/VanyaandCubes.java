
import java.util.*;
import java.util.Collections;

public class VanyaandCubes
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i=1,sum=1,lev=0,tot=1;
		n=sc.nextInt();
		while(tot<=n) {
			i++;
			sum+=i;
			tot+=sum;
			lev++;		
		}
		System.out.println(lev);
		sc.close();
	}
}

