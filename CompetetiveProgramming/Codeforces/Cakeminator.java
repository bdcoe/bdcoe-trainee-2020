
import java.util.*;
import java.util.Collections;

public class Cakeminator
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,m,i,j,count=0,flag=0;
		
		n=sc.nextInt();
		m=sc.nextInt();
		
		char arr[][]=new char[n][m];
		boolean vis[][]=new boolean[n][m];
		
		for(i=0;i<n;i++) 
			arr[i]=sc.next().toCharArray();		
	
		for(i=0;i<n;i++) {
			flag=0;
			for(j=0;j<m;j++) {
				if(arr[i][j]=='S') {
					flag=1;break;
				}
			}
			if(flag==0) {
				for(j=0;j<m;j++) {
					vis[i][j]=true;
					count++;
				}
			}
		}
		
		for(j=0;j<m;j++) {
			flag=0;
			for(i=0;i<n;i++) {
				if(arr[i][j]=='S') {
					flag=1;break;
				}
			}
			if(flag==0) {
				for(i=0;i<n;i++) {
					if(vis[i][j]==false)
						count++;
					vis[i][j]=true;
				}
			}
		}
		
		System.out.println(count);

		sc.close();
	}
}
