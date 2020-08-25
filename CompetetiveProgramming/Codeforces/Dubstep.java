
import java.util.*;
import java.util.Collections;

public class Dubstep
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int i;
		String s,ans="";

		s=sc.nextLine();
		
		for(i=0;i<s.length();i++) {
			int flag=0;
			char p=s.charAt(i);
			if(p=='W'&& s.length()-i>2) {
				if(s.charAt(i+1)=='U' && s.charAt(i+2)=='B') {
					flag=1;
					i+=2;
					ans=ans+" ";
				}
			}
			if(flag!=1)
				ans=ans+p;
		}
		ans=ans.trim();
		System.out.println(ans);

		sc.close();
	}
}

