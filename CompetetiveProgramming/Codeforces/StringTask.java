

import java.util.*;
import java.util.Collections;

public class StringTask
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int i;
		String s,ans="";
		
		s=sc.nextLine();
		s=s.toLowerCase();
		for(i=0;i<s.length();i++) {
			char p=s.charAt(i);
			if(p!='a' && p!='e' && p!='i' && p!='o' && p!='u' && p!='y') {
				ans=ans+"."+String.valueOf(p);
			}
		}
		System.out.println(ans);

		sc.close();
	}
}

