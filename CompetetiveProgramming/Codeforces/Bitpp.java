
import java.util.*;
import java.util.Collections;

public class Bitpp
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,x;
		x=0;
		String pi,poi,pd,pod,s;
		pi="++X";poi="X++";pd="--X";pod="X--";

		n=sc.nextInt();
		sc.nextLine();
		while(n-->0) {
			s=sc.nextLine();
			if(s.equals(pi))
				++x;
			if(s.equals(poi))
				x++;
			if(s.equals(pd))
				--x;
			if(s.equals(pod))
				x--;
		}
		
		System.out.println(x);

		sc.close();
	}
}

