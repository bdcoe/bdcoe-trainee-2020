
import java.util.*;
import java.util.Collections;

public class DreamoonandStairs
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,m,moves,moves1;
		

		n=sc.nextInt();
		m=sc.nextInt();
		
		if(n%2==0)
			moves=n/2;
		else
			moves=n/2+1;
		
		moves1=n;
		
		if(moves<m && moves1<m) {
			System.out.println("-1");
			System.exit(0);
		}
		if(moves<m) {
		System.out.println(m);
		}
		else {
		if(moves%m==0)
			System.out.println(moves);
		else {
		int t=moves/m;
			System.out.println(m*(t+1));
		}
		}
		sc.close();
	}
}