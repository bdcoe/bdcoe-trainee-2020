
import java.util.*;


public class CommonPrefixes_659
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,n,i;
		
		t=sc.nextInt();
		
		while(t-->0) {
		n=sc.nextInt();	
		
		String s="";
		String temp;
		
	
		int arr[]=new int[n];
		for(i=0;i<n;i++)
			arr[i]=sc.nextInt();
			
		for(i=1;i<=200;i++) 
			s=s+"a";
		
		temp=s;	
		System.out.println(s);
		
		for(i=0;i<n;i++) {
			char p=temp.charAt(arr[i]);
			if(p=='a') {
				temp=temp.substring(0,arr[i])+"b"+temp.substring(arr[i]+1);
				System.out.println(temp);
				continue;
			}
			if(p=='b') {
				temp=temp.substring(0,arr[i])+"a"+temp.substring(arr[i]+1);
				System.out.println(temp);
			}
		}

		}

		sc.close();
	}
}

