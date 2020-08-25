

import java.util.*;
import java.util.Collections;

public class PashmakandGarden
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int x1=sc.nextInt();
		int y1=sc.nextInt();
		int x2=sc.nextInt();
		int y2=sc.nextInt();
 
		int diff;
		if (x1==x2 && y1!=y2)
		{
			diff=y2-y1;
			x1+=diff;
			x2+=diff;
			System.out.println(x1+" "+y1+" "+x2+" "+y2);
		}
		else if (y1==y2 && x1!=x2)
		{
			diff=x2-x1;
			y1+=diff;
			y2+=diff;
			System.out.println(x1+" "+y1+" "+x2+" "+y2);
		}
		else if (Math.abs(x2-x1)!=Math.abs(y2-y1))
		{
			System.out.println(-1);
		}
		else
		{
			System.out.println(x1+" "+y2+" "+x2+" "+y1 );
		}

		sc.close();
	}
}

