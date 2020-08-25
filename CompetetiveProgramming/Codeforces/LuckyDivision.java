
import java.util.*;
import java.util.Collections;

public class LuckyDivision
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int i,n,flag=0;
		


		int arr[]={4,7,44,47,74,77,444,447,474,477,744,747,774,777};
		
		n=sc.nextInt();
		
		for(i=0;i<arr.length;i++) {
			if(n%arr[i]==0) {
				flag=1;
				break;
			}
		}
		if(flag!=1)
		System.out.println("NO");
		else
			System.out.println("YES");

		sc.close();
	}
}

