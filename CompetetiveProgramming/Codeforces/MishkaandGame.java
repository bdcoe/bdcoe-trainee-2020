

import java.util.*;
import java.util.Collections;

public class MishkaandGame
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,a,b,mish=0,chris=0;
		
		t=sc.nextInt();
		while(t-->0) {
			a=sc.nextInt();
			b=sc.nextInt();
			if(a>b)
				mish++;
			if(b>a)
				chris++;
		}
		if(mish>chris)
			System.out.println("Mishka");
		if(chris>mish)
			System.out.println("Chris");
		if(mish==chris)
			System.out.println("Friendship is magic!^^");

		sc.close();
	}
}

