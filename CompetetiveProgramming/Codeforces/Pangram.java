

import java.util.*;
import java.util.Collections;

public class Pangram
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,flag=0;
		String s;

		n=sc.nextInt();
		sc.nextLine();
		s=sc.nextLine();
		s=s.toUpperCase();
		int arr[]=new int[256];
		Arrays.fill(arr, 0);
		for(i=0;i<n;i++) {
			char p=s.charAt(i);
			arr[(int)p]=1;
		}
		for(i=65;i<=90;i++) {
			if(arr[i]==0) {
				flag=1;
				break;
			}
		}
		if(flag==1)
		System.out.println("NO");
		else
			System.out.println("YES");

		sc.close();
	}
}

