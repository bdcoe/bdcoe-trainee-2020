
import java.util.*;
import java.util.Collections;

public class GamewithSticks
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int m,n,count;
		count=0;
	
		n=sc.nextInt();
		m=sc.nextInt();
		
		int i=1;
		while(true) {
			if((n-i)==0 || (m-i)==0)
				break;
			count++;
			i++;
		}
		if(count%2==0)
			System.out.println("Akshat");
		else
			System.out.println("Malvika");
		sc.close();
	}
}

