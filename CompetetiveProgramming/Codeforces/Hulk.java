

import java.util.*;
import java.util.Collections;

public class Hulk
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,j;
		String s,ht,lt,ans;
		ans="";
		ht="I hate ";
		lt="I love ";

		n=sc.nextInt();
		for(i=1;i<=n;i++) {
			if(i%2!=0)
				ans=ans+ht;
			if(i%2==0)
				ans=ans+lt;
			if(i!=n)
				ans=ans+"that ";
		}
		
		System.out.println(ans+"it");

		sc.close();
	}
}
