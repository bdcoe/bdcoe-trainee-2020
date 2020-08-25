
import java.util.*;
import java.util.Collections;

public class GennadyandCardGame
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int i,flag=0;
		String s;
		s=sc.nextLine();
		
		String[] arr=new String[5];
		
		for(i=0;i<5;i++)
			arr[i]=sc.next();
		
		for(i=0;i<5;i++) {
		if(arr[i].charAt(0)==s.charAt(0) || arr[i].charAt(1)==s.charAt(1)) {
			flag=1;
			break;
		}
		}
		
		if(flag==1)
		System.out.println("YES");
		else
			System.out.println("NO");

		sc.close();
	}
}
