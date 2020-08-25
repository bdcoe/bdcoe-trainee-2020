
import java.util.*;
import java.util.Collections;

public class CHECHOC
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,n,temp,m,x,y,ans;
		

		t=sc.nextInt();
		while(t-->0) {
		n=sc.nextInt();
		m=sc.nextInt();
		x=sc.nextInt();
		y=sc.nextInt();
		
		if(n%2==0 && m%2==0) {
			ans=(y*n/2)*m;
			System.out.println(ans);
		}
		if(n%2==0 && m%2!=0) {
			ans=(y*n/2)*m;
			System.out.println(ans);
		}
		
		if(n%2!=0 && m%2==0) {
			ans=(y*m/2)*n;
			System.out.println(ans);
		}
		if(n%2!=0 && m%2!=0 && y%2!=0) {
			ans=(n*m)*(int)Math.floor(y/2.0)+(int)Math.floor((n*m)/2.0);
			System.out.println(ans);
		}
		if(n%2!=0 && m%2!=0 && y%2==0) {
			ans=n*m*(y/2);
			System.out.println(ans);
		}
		}

		sc.close();
	}
}

