
import java.util.*;
import java.util.Collections;

public class DivisibilityProblem
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,a,b,n,ans,temp;

		t=sc.nextInt();
		while(t-->0) {
			a=sc.nextInt();
			b=sc.nextInt();
			if(a%b==0)
				System.out.println("0");
			else {
				n=a/b;
				temp=b*(n+1);
				ans=temp-a;
				System.out.println(ans);
			}
		}
		
		System.out.println();

		sc.close();
	}
}

