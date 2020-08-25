//WA

import java.util.*;
import java.util.Collections;

public class SKMP
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,i,j=0;
		String s,p;
		
		t=sc.nextInt();
		sc.nextLine();
		while(t-->0) {
			s=sc.nextLine();
			p=sc.nextLine();
			String temp="";
			
			
			
			int sar[]=new int[123];
			int par[]=new int[123];
			
			for(i=0;i<s.length();i++)
				sar[(int)s.charAt(i)]++;
		
			for(i=0;i<p.length();i++)
				par[(int)p.charAt(i)]++;
			
			for(i=97;i<=122;i++) 
				sar[i]=sar[i]-par[i];
			
			for(i=97;i<=122;i++) {
				if(sar[i]>0) {
				for(j=1;j<=sar[i];j++)
					temp=temp+(char)i;
			}	
			}
			
			char h=p.charAt(0);
			for(i=0;i<temp.length()-1;i++) {	
				if(temp.charAt(i)>h) {
				temp=temp.substring(0,i)+p+temp.substring(i,temp.length());
				break;
				}
				if(temp.charAt(i)==h && p.charAt(1)<h) {
					temp=temp.substring(0,i)+p+temp.substring(i,temp.length());
					break;
				}		
			}
				System.out.println(temp);	
		}
	
		sc.close();
	}

}
