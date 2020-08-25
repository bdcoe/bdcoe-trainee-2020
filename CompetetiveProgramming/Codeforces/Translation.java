
import java.util.*;
import java.util.Collections;

public class Translation
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int i;
		String s,t,ans;
		ans="";
		s=sc.nextLine();
		t=sc.nextLine();
		for(i=s.length()-1;i>=0;i--) {
			char p=s.charAt(i);
			ans=ans+String.valueOf(p);
		}
		if(ans.equals(t))
		System.out.println("YES");
		else
			System.out.println("NO");
		sc.close();
	}
}

