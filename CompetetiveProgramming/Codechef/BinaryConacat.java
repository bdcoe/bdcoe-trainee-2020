

import java.util.*;
import java.util.Collections;

public class BinaryConacat
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,n,i,j;
		

		t=sc.nextInt();
		while(t-->0) {
		n=sc.nextInt();
		int arr[]=new int[n];
		String s,p,xpy,ypx;
		int max=0,xy,yx,diff;
		
		for(i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		for(i=0;i<n-1;i++) {
			for(j=i+1;j<n;j++) {
				s=Integer.toBinaryString(arr[i]);
				p=Integer.toBinaryString(arr[j]);
				xpy=s+p;
				ypx=p+s;
				
				xy=Integer.parseInt(xpy,2);
				yx=Integer.parseInt(ypx,2);
				
				diff=xy-yx;
				if(diff>max)
					max=diff;
			}
		}
		
		
		}
		System.out.println();

		sc.close();
	}
}

