

import java.util.*;
import java.util.Collections;

public class UniversityClasses
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i;
		String s;
		n=sc.nextInt();
		int arr[]=new int[7];
		Arrays.fill(arr, 0);
		sc.nextLine();
		while(n-->0) {
			s=sc.nextLine();
			for(i=0;i<7;i++) {
				char p=s.charAt(i);
				if(p=='1')
					arr[i]++;
			}
		}
		Arrays.sort(arr);
		System.out.println(arr[6]);

		sc.close();
	}
}

