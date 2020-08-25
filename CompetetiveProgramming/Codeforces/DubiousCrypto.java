

import java.util.*;
import java.util.Collections;

public class DubiousCrypto
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,n,i,j,l,r,a,b,c,k,flag=0;
		long m;
		t=sc.nextInt();
		a=0;b=0;c=0;
		while(t-->0) {
			l=sc.nextInt();
			r=sc.nextInt();
			m=sc.nextLong();
			n=1;
			while(true) {
			for(i=l;i<=r;i++) {
				a=i;
				for(j=l;j<=r;j++) {
					b=j;
					for(k=l;k<=r;k++) {
						c=k;
						if(n*a+b-c==m) {
							flag=1;
							break;
						}
					}
					if(flag==1)
						break;
				}
				if(flag==1)
					break;
			}
			if(flag==1) {
				System.out.println(a+" "+b+" "+c);
				break;
			}
			else
				n++;
		}
			flag=0;
			
		}

		sc.close();
	}
}
