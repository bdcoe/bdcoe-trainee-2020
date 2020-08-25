
import java.util.*;
import java.util.Collections;

public class StonesontheTable
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,count;
		count=0;
		n=sc.nextInt();
		sc.nextLine();
		String s;
		s=sc.nextLine();
		
		char arr[]=s.toCharArray();
	
		
		for(i=0;i<n-1;i++) {
			if(arr[i+1]==arr[i])
				count++;
		}
			
		System.out.println(count);

		sc.close();
	}
}

