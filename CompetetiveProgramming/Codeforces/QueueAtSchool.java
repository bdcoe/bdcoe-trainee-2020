
import java.util.*;
import java.util.Collections;

public class QueueAtSchool
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,n,i;
		String s,ans;
		ans="";
		char temp;
		n=sc.nextInt();
		t=sc.nextInt();
		sc.nextLine();
		s=sc.nextLine();
		char arr[]=s.toCharArray();
		while(t-->0) {
			for(i=0;i<n-1;i++) {
				if(arr[i]=='B' && arr[i+1]=='G') {
					temp=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=temp;
					i++;
				}
					
			}
		}
		for(i=0;i<n;i++)
		ans=ans+String.valueOf(arr[i]);
		System.out.println(ans);

		sc.close();
	}
}

