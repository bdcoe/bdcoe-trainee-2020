
import java.util.*;
import java.util.Collections;

public class RestorePermutation_656
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,n,i,j;
	
		t=sc.nextInt();
		while(t-->0) {
		n=sc.nextInt();
		int arr[]=new int[2*n];
		int b[]=new int[n];
		int k=0,flag=0;
		for(i=0;i<2*n;i++)
			arr[i]=sc.nextInt();
		
		for(i=0;i<2*n;i++) {
			for(j=0;j<n;j++) {
				if(arr[i]==b[j]) {
					flag=1;
					break;
				}
			}		
			if(flag!=1) {
					b[k]=arr[i];
					k++;
			}
			flag=0;
		}
		for(i=0;i<n;i++)
			System.out.print(b[i]+" ");
		System.out.println();
		}
		sc.close();
	}
}

