
import java.util.*;
import java.util.Collections;

public class BoyOrGirl
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,j,count;
		count=0;
		String s;

		s=sc.nextLine();
		n=s.length();
		
		char arr[]=s.toCharArray();
		boolean visited[]=new boolean[n];
		Arrays.fill(visited, false);
		for(i=0;i<n;i++) {
			if(visited[i]==false) {
			for(j=i+1;j<n;j++) {
				if(arr[j]==arr[i]) {
					count++;
					visited[j]=true;
				}
			}
		}
		}
		if((n-count)%2!=0)
		System.out.println("IGNORE HIM!");
		else
			System.out.println("CHAT WITH HER!");

		sc.close();
	}
}

