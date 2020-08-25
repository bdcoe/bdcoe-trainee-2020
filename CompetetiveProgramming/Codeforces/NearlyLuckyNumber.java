
import java.util.*;
import java.util.Collections;

public class NearlyLuckyNumber
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int i,count;
		count=0;
		long n;
		String s;

		n=sc.nextLong();
		s=Long.toString(n);
		for(i=0;i<s.length();i++) {
			char p=s.charAt(i);
			if(p=='4' || p=='7')
				count++;
		}
		if(count==4 || count==7)
		System.out.println("YES");
		else
			System.out.println("NO");

		sc.close();
	}
}

