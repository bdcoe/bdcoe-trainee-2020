
import java.util.*;
import java.util.Collections;

public class Contest
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int mp,vp,c,d;
		int misha,vasya;
		
		mp=sc.nextInt();
		vp=sc.nextInt();
		c=sc.nextInt();
		d=sc.nextInt();
		
		misha=Math.max((3*mp)/10, mp-(mp*c)/250);
		
		vasya=Math.max((3*vp)/10, vp-(vp*d)/250);
		
		if(misha>vasya)
			System.out.println("Misha");
		else if(vasya>misha)
			System.out.println("Vasya" );
		else
			System.out.println("Tie" );

		sc.close();
	}
}
