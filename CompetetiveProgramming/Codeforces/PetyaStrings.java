

import java.util.*;
import java.util.Collections;

public class PetyaStrings
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int ans;
		String s,p;

		s=sc.nextLine();
		p=sc.nextLine();
		
		ans=s.compareToIgnoreCase(p);
		if(ans>0)
			ans=1;
		if(ans<0)
			ans=-1;
		System.out.println(ans);

		sc.close();
	}
}

