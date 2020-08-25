
import java.util.*;
import java.util.Collections;

public class BrainsPhoto
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int m,n,i,j,flag=0;
		

		n=sc.nextInt();
		m=sc.nextInt();
		char arr[][]=new char[n][m];
		for(i=0;i<n;i++) {
			for(j=0;j<m;j++) {
				arr[i][j]=sc.next().charAt(0);
			}
		}
		
		for(i=0;i<n;i++) {
			for(j=0;j<m;j++) {
				if(arr[i][j]=='C' || arr[i][j]=='M' || arr[i][j]=='Y') {
					flag=1;
					break;
				}
			}
			if(flag==1)
				break;
		}
		if(flag==1)
		System.out.println("#Color");
		else
			System.out.println("#Black&White");

		sc.close();
	}
}

