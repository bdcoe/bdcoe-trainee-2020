
import java.util.*;
import java.util.Collections;

public class BuyaShovel
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int k,r,count=1,temp;
		
		k=sc.nextInt();
		r=sc.nextInt();
		
		while(true) {
			temp=k*count;
			if(temp%10==0 || temp%10==r)
				break;
			else
				count++;
		}
		System.out.println(count);

		sc.close();
	}
}

