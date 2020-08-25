
import java.util.*;
import java.util.Collections;

public class InsomniaCure
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int d,n,i,k,l,m,count,flag=0;
		count=0;
		k=sc.nextInt();
		l=sc.nextInt();
		m=sc.nextInt();
		n=sc.nextInt();
		d=sc.nextInt();
		
		for(i=1;i<=d;i++) {
			if(k==1 || l==1 || m==1 || n==1 ) {
				flag=1;
				break;
			}
			else {
				if(i%k!=0 && i%l!=0 && i%m!=0 && i%n!=0)
					count++;
			}
		}
		if(flag==1)
		System.out.println(d);
		else
			System.out.println(d-count);

		sc.close();
	}
}

