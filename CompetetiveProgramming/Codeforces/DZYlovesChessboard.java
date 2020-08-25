
import java.util.*;
import java.util.Collections;

public class DZYlovesChessboard
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,j,m;
		

		n=sc.nextInt();
		m=sc.nextInt();
		char arr[][]=new char[n][m];
		char b[][]=new char[n][m];
		
		for(i=0;i<n;i++) 
			arr[i]=sc.next().toCharArray();
		
		for(i=0;i<n;i++) {
			for(j=0;j<m;j++) {
				if((i+j)%2==0)
					b[i][j]='B';
				else
					b[i][j]='W';
			}
		}
		
		for(i=0;i<n;i++) {
			for(j=0;j<m;j++) {
				if(arr[i][j]=='-')
					b[i][j]='-';
			}
		}
		
			
		for(i=0;i<n;i++) {
			for(j=0;j<m;j++) {
				System.out.print(b[i][j]);
			}
			System.out.println();
		}
		sc.close();
	}
}
