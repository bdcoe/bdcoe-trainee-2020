
import java.util.*;
import java.util.Collections;

public class GameGame_659
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,n,i;

		t=sc.nextInt();
		while(t-->0) {
		n=sc.nextInt();
		long koa=0,bf=0;
		int arr[]=new int[n];
			
		for(i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
			for(i=0;i<n;i++) {
				if(i%2==0) {
					koa=(koa^arr[i]);
				}
				else
					bf=(bf^arr[i]);
			}
			if(koa>bf)
				System.out.println("WIN");
			if(koa<bf)
				System.out.println("LOSE");
			if(koa==bf)
				System.out.println("DRAW");
		}
		

		sc.close();
	}
}

