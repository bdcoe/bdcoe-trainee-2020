//NOT DONE

import java.util.*;
import java.util.Collections;

public class LCMproblm_E92
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);
		
		

		int t,l,r,i,j=0,ans;
		
		t=sc.nextInt();
		while(t-->0) {
		l=sc.nextInt();
		r=sc.nextInt();
		int flag=0;
		
		for(i=l;i<=r;i++) {
			for(j=i+1;j<=r;j++) {
			
				ans=lcm(i,j);
				
				if(ans<=r && ans>=l) {
					flag=1;
					break;
				}
			}
			if(flag==1)
				break;
		}
		if(flag==1)
			System.out.println(i+" "+j);
		else
			System.out.println("-1 -1");
		}

		sc.close();
	}
	
	
	static int gcd(int a, int b) 
    { 
    if (a == 0) 
        return b;  
    return gcd(b % a, a);  
    } 
	
	
	 static int lcm(int a, int b) 
	    { 
	        return (a*b)/gcd(a, b); 
	    } 
	
}

