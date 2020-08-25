
import java.util.*;
import java.util.Collections;

public class NewYearandHurry
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,k,temp=0,count=0;
		
		n=sc.nextInt();
		k=sc.nextInt();
		
		for(i=1;i<=n;i++) {
			temp+=5*i;
			if(temp+k<=240)
				count++;
			else
				break;
		}
		System.out.println(count);

		sc.close();
	}
}

