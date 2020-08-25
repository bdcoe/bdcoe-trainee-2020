
import java.util.*;
import java.util.Collections;

public class EmailfromPolycarp
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int tc,i,j,pos,flag;
		
		String s,t;
		
		tc=sc.nextInt();
		sc.nextLine();
		while(tc-->0) {
			s=sc.next();
			t=sc.next();
			flag=pos=0;
			char p,q,r;
			char temp = 0;
			for ( i = 0; i < s.length(); i++) {
				if(s.length()>t.length()) {
					flag=1; 
					break;
				}
				p=s.charAt(i);
				if(p==temp)
					pos--;
				for(j=pos;j<t.length()-1;j++) {
					q=t.charAt(j);
					r=t.charAt(j+1);
					if(p==q) {
						if(r==q) {
							pos++;
							temp=q;
							continue;
						}
					if(r!=q)
						pos++;
						break;
				}
					else {
						flag=1;
						break;
					}
				
				}
				if(flag==1)
					break;
				
			}
			if(flag==1)
				System.out.println("NO");
			else
				System.out.println("YES");
		}
		sc.close();
	}
}

