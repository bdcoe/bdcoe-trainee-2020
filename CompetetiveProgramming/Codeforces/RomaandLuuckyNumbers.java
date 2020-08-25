
import java.util.*;
import java.util.Collections;

public class RomaandLuuckyNumbers
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,k,i,j,count=0;
		String s;
		n=sc.nextInt();
		k=sc.nextInt();
		int arr[]=new int[n];
		
		for(i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		for(i=0;i<n;i++) {
			int temp=0;
			s=Integer.toString(arr[i]);
			for(j=0;j<s.length();j++) {
				char p=s.charAt(j);
				if(p=='4' || p=='7')
					temp++;
			}
			if(temp>k)
				count++;
		}
		System.out.println(n-count);
		sc.close();
	}
}

