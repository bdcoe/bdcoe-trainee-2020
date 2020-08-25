
import java.util.*;
import java.util.Collections;

public class TeamOlympiad
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,j,count=0,flag=0,k=0;
		

		n=sc.nextInt();
		int arr[]=new int[n];
		int b[]=new int[n];
		for(i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		boolean visited[]=new boolean[n];
		Arrays.fill(visited, false);
		
		while(true) {
			for(i=1;i<=3;i++) {
				 flag=0;
				for(j=0;j<n;j++) {
					if(visited[j]==false) {
						if(arr[j]==i) {
							b[k]=j+1;
							flag=1;
							visited[j]=true;
							k++;
							break;
						}
					}
				}
				if(flag==0)
					break;
			}
			if(flag==0)
				break;
			count++;
		}
		
		System.out.print(count);
		for(i=0;i<3*count;i++){
			if(i%3==0)
				System.out.println();
			System.out.print(b[i]+" ");	
		}
		
		sc.close();
	}
}

