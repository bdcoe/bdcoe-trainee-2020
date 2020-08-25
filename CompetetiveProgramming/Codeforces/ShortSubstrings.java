
import java.util.*;
import java.util.Collections;

public class ShortSubstrings
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,i;
		String s,ans;
		ans="";
		t=sc.nextInt();
		sc.nextLine();
		while(t-->0) {
			s=sc.nextLine();
			for(i=0;i<s.length();i+=2) {
				char p=s.charAt(i);
				ans=ans+String.valueOf(p);
			}
			if(s.length()%2==0)
				ans=ans+String.valueOf(s.charAt(s.length()-1));
			
			System.out.println(ans);
			ans="";
		}
		
	

		sc.close();
	}
}

