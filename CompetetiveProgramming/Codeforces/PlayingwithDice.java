
import java.util.*;
import java.util.Collections;

public class PlayingwithDice
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int a,b,avg,diff;

		a=sc.nextInt();
		b=sc.nextInt();
		
		avg=(a+b)/2;
		diff=Math.abs(a-b);
		if(diff%2==0) {
			if(a==b) {
				System.out.println("0 6 0");
				System.exit(0);
			}
			if(a<=avg)
				System.out.println(avg-1+" 1 "+(6-avg));
			if(b<=avg)
				System.out.println((6-avg)+" 1 "+(avg-1));
		}
		else {
			if(a<=avg)
				System.out.println(avg+" 0 "+(6-avg));
			if(b<=avg)
				System.out.println((6-avg)+" 0 "+avg);
		}

		sc.close();
	}
}
