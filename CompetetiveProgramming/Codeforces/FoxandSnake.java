
import java.util.*;
import java.util.Collections;

public class FoxandSnake
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int m,n,i,j;
		

		n=sc.nextInt();
		m=sc.nextInt();
		for(i=1;i<=n;i++) {
			if(i%2!=0) {
			for(j=1;j<=m;j++) 
				System.out.print("#");
			System.out.println();
			}
			else {
				if(i%2==0 && i%4!=0) {
					for(j=1;j<m;j++)
						System.out.print(".");
					System.out.print("#");
					System.out.println();
				}
				if(i%4==0) {
					System.out.print("#");
					for(j=1;j<m;j++)
						System.out.print(".");
					System.out.println();
				}
			}
		}


		sc.close();
	}
}

