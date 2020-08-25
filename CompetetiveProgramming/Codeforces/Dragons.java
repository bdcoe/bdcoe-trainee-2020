
import java.util.*;
import java.util.Collections;

public class Dragons
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int temp,temp2,n,i=0,flag=0,flag2=0,j,max;
		int s;

		s=sc.nextInt();
		n=sc.nextInt();
		int m=n;
		int arr[]=new int[n];
		int b[]=new int[n];
		
		while(m-->0) {
			arr[i]=sc.nextInt();
			b[i]=sc.nextInt();
			i++;
		}
		
		for(i=0;i<n-1;i++) {
			for(j=i+1;j<n;j++) {
				if(arr[j]<arr[i]) {
					temp=arr[j];
					arr[j]=arr[i];
					arr[i]=temp;
					temp2=b[j];
					b[j]=b[i];
					b[i]=temp2;
				}
			}
		}
		
		max=arr[arr.length-1];
		
		for(i=0;i<arr.length;i++) {
			if(arr[i]<s)
				s+=b[i];
			if(s>max) {
				flag=1;
				break;
			}
			if(arr[i]>=s) {
				flag2=1;
				break;
			}
		}
		if(flag==1)
			System.out.println("YES");
		if(flag2==1)
			System.out.println("NO");
		
		sc.close();
	}
}

