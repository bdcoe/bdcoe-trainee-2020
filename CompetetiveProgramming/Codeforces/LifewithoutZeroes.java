
import java.util.*;
import java.util.Collections;

public class LifewithoutZeroes
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int a,b,i;
		int ans,ans1;
		String s,p,t="",m="",k="",l="";

		a=sc.nextInt();
		b=sc.nextInt();
		ans=a+b;
		k=Integer.toString(ans);
		for(i=0;i<k.length();i++) {
			if(k.charAt(i)!='0')
				l=l+k.charAt(i);
		}
		ans=Integer.parseInt(l);
		
		s=Integer.toString(a);
		p=Integer.toString(b);
		
		for(i=0;i<s.length();i++) {
			if(s.charAt(i)!='0')
				t=t+s.charAt(i);
		}
		for(i=0;i<p.length();i++) {
			if(p.charAt(i)!='0')
				m=m+p.charAt(i);
		}
		
		ans1=Integer.parseInt(t)+Integer.parseInt(m);
		
		if(ans==ans1)
		System.out.println("YES");
		else
			System.out.println("NO");

		sc.close();
	}
}
