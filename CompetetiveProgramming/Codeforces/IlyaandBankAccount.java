
import java.util.*;
import java.util.Collections;

public class IlyaandBankAccount
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n;
		String s;

		n=sc.nextInt();
		
		s=Integer.toString(n);
		
		int temp,temp2;
		temp=Integer.parseInt(s.substring(0, s.length()-1));
		temp2=Integer.parseInt(s.substring(0, s.length()-2)+s.charAt(s.length()-1));
		
		if(temp>temp2 && temp>n)
			System.out.println(temp);
		else if(n>temp2)
			System.out.println(n);
		else
			System.out.println(temp2);

		sc.close();
	}
}
