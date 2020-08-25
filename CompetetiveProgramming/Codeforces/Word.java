
import java.util.*;
import java.util.Collections;

public class Word
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int i,lcount,ucount;
		String s;
		lcount=ucount=0;

		s=sc.nextLine();
		for(i=0;i<s.length();i++) {
			char p=s.charAt(i);
			if(Character.isLowerCase(p))
				lcount++;
			else
				ucount++;
		}
		if(lcount>=ucount)
		System.out.println(s.toLowerCase());
		else
			System.out.println(s.toUpperCase());

		sc.close();
	}
}

