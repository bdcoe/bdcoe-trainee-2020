
import java.util.*;
import java.util.Collections;

public class EventualReduction
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,n,i,j,count=0,flag=0;
		String s;

		t=sc.nextInt();
		
		while(t-->0) {
		n=sc.nextInt();	
		sc.nextLine();
		s=sc.nextLine();
		s=s.toLowerCase();
		
		char arr[]=s.toCharArray();
		boolean visited[]=new boolean[n];
		Arrays.fill(visited, false);
		for(i=0;i<n;i++) {
			if(visited[i]==false) {
			for(j=0;j<n;j++) {
				if(arr[i]==arr[j]) {
					count++;
					visited[j]=true;
				}
			}
			}
			if(count%2!=0) {
				flag=1;
				count=0;
				break;
			}
			count=0;
			}
		if(flag==1)
			System.out.println("NO");
		else
			System.out.println("YES");
		flag=0;
		}
		

		sc.close();
	}
}

