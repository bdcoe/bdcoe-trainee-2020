
import java.util.*;
import java.util.Collections;

public class CommonSubsequence
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,n,i,j,m,max,min;
		

		t=sc.nextInt();
		while(t-->0) {
			n=sc.nextInt();
			m=sc.nextInt();
		int arr[]=new int[n];
		int b[]=new int[m];
		int flag=0,ans=0;
		
		for(i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		for(i=0;i<m;i++)
			b[i]=sc.nextInt();
		
		max=Math.max(arr.length, b.length);
		min=Math.min(arr.length, b.length);
		if(max==arr.length) {
			for(i=0;i<max;i++) {
				for(j=0;j<min;j++) {
					if(arr[i]==b[j]) {
						flag=1;
						ans=arr[i];
						break;
					}
				}
			}
		}
		if(flag==0) {
		if(max==b.length) {
			for(i=0;i<max;i++) {
				for(j=0;j<min;j++) {
					if(b[i]==arr[j]) {
						flag=1;
						ans=b[i];
						break;
					}
				}
			}
		}
		}
		if(flag==1) {
			System.out.println("YES");
			System.out.print("1"+" "+ans);
			System.out.println();
		}
		else
			System.out.println("NO");
		
		}
		

		sc.close();
	}
}

