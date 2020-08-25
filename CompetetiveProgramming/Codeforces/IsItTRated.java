

import java.util.*;
import java.util.Collections;

public class IsItTRated
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,flag,flag1;
		
		flag=flag1=0;

		n=sc.nextInt();
		int arr[]=new int[n];
		int b[]=new int[n];
		for(i=0;i<n;i++) {
			arr[i]=sc.nextInt();
			b[i]=sc.nextInt();
		}
			
		for(i=0;i<n;i++) {
			if(arr[i]!=b[i]) {
				flag=1;
				System.out.println("rated");
				break;
			}
		}
		if(flag!=1) {
		for(i=0;i<n-1;i++) {
			if(arr[i]==b[i]) {
				if(arr[i+1]>arr[i]) {
					flag1=1;
					System.out.println("unrated");
					break;
				}
			
			}
		}
		}
		if(flag1!=1 && flag!=1)
			System.out.println("maybe");
			
		

		sc.close();
	}
}

