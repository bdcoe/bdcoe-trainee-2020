
import java.util.*;
import java.util.Collections;

public class Marks
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,m,i,j,k,count=0;
		
		n=sc.nextInt();
		m=sc.nextInt();
		
		char arr[][]=new char[n][m];
		
		
		for(i=0;i<n;i++) 
			arr[i]=sc.next().toCharArray();
		
		for(i=0;i<n;i++) {
			int flag=0;
			for(j=0;j<m;j++) {
				int flag2=1;
				for(k=0;k<n;k++) {
					if(arr[k][j]>arr[i][j])
						flag2=0;
				}
				if(flag2==1)
					flag=1;
			}
			if(flag==1)
				count++;
		}
			
		System.out.println(count);

		sc.close();
	}
}
