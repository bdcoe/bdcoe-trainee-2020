
import java.util.*;
import java.util.Collections;

public class GigaTower
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		long i,flag=0;
		int j;
		long n;
		String s;

		n=sc.nextLong();
		
		
		
		if(n>0) {
			for(i=1;i<=10;i++) {
				s=Long.toString(n+i);
				int len=s.length();
				for(j=0;j<len;j++) {
					char p=s.charAt(j);
					if(p=='8') {
						flag=1;break;
					}
				}
				if(flag==1) {
					System.out.println(i);
					break;
				}
			}
		}
		else {
			for(i=1;i<=20;i++) {
				s=Long.toString(n+i);
				int len=s.length();
				for(j=0;j<len;j++) {
					char p=s.charAt(j);
					if(p=='8') {
						flag=1;
						break;
					}
				}
				if(flag==1) {
					System.out.println(i);
					break;
				}
			}
		}

		sc.close();
	}
}

