
import java.util.*;
import java.util.Collections;

public class BachgoldProblem
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,x,j=1,temp;
		String s="";
		
		n=sc.nextInt();
		temp=n;
		
		while(true) {
			x=2*j;
			s=s+"2";
			if(n-x==0 || n-x==1)
				break;
			j++;
		}
		
		if(temp%2==0) {
			System.out.println(s.length());
			for(i=0;i<s.length();i++) 
				System.out.print(s.charAt(i)+" ");
			
		}
		else {
		System.out.println(s.length());
		s=s.substring(0,s.length()-1)+"3";
		for(i=0;i<s.length();i++) 
			System.out.print(s.charAt(i)+" ");
		}
		sc.close();
	}
}
