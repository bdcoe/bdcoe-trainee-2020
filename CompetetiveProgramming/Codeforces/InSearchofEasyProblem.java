

import java.util.*;
import java.util.Collections;

public class InSearchofEasyProblem
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,flag=0;
		n=sc.nextInt();
		int arr[]=new int[n];
		
		for(i=0;i<n;i++) 
			arr[i]=sc.nextInt();
		
		for(i=0;i<n;i++) {
			if(arr[i]==1) {
				flag=1;break;
			}
		}
		if(flag==1)
		System.out.println("HARD");
		else
			System.out.println("EASY");

		sc.close();
	}
}

