
import java.util.*;
import java.util.Collections;

public class AntonandDainik
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,ca,cd;
		ca=cd=0;
		String s;

		n=sc.nextInt();
		sc.nextLine();
		s=sc.nextLine();
		for(i=0;i<s.length();i++) {
			char p=s.charAt(i);
					if(p=='A')
						ca++;
					else
						cd++;
		}
		if(ca>cd)
		System.out.println("Anton" );
		if(cd>ca)
			System.out.println("Danik");
		if(ca==cd)
			System.out.println("Friendship" );

		sc.close();
	}
}

