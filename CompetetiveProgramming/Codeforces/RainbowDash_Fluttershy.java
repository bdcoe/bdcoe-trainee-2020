
import java.util.*;
import java.util.Collections;

public class RainbowDash_Fluttershy
{
	public static void main(String args[])
	{
		

		Scanner sc=new Scanner(System.in);
 
		int t,n;
		
 
		t=sc.nextInt();
		while(t-->0) {
			n=sc.nextInt();
 
			System.out.println((int)Math.floor(n/2.0)+1);
		}
 
		sc.close();
	}
}

