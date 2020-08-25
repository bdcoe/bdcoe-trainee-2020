
import java.util.*;
import java.util.Collections;

public class ChatRoom
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,i,j,pos=-1;
		String s,ans="",str="hello";

		s=sc.nextLine();
		
		for(i=0;i<5;i++) {
			char p=str.charAt(i);
		for(j=pos+1;j<s.length();j++) {
			char q=s.charAt(j);
			if(p==q) {
				ans=ans+q;
				pos=j;
				break;
			}
		}
		}
		if(ans.equals("hello"))
		System.out.println("YES");
		else
			System.out.println("NO");

		sc.close();
	}
}

