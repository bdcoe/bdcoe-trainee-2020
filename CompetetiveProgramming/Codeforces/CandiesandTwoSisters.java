
import java.util.*;
import java.util.Collections;

public class CandiesandTwoSisters
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,n;

		t=sc.nextInt();
		while(t-->0) {
			n=sc.nextInt();
			System.out.println((int)Math.floor((n-1)/2));
		}
		sc.close();
	}

}
