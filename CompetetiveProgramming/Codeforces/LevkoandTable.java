
import java.util.*;
import java.util.Collections;

public class LevkoandTable
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int k,n,i,j;

		n=sc.nextInt();
		k=sc.nextInt();
		int m=k-n+1;
		
		int arr[][]=new int[n][n];
		
		for(i=0;i<n;i++) {
			for(j=0;j<n;j++) {
				if(i==j)
					arr[i][j]=m;
				else
					arr[i][j]=1;
			}
		}
		
		for(i=0;i<n;i++) {
			for(j=0;j<n;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		sc.close();
	}
}
