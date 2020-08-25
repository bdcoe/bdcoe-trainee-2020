
import java.util.*;
import java.util.Collections;

public class OmkarandCompletion
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,n,i,flag,j,k,c;
		flag=c=0;

		t=sc.nextInt();
		while(t-->0) {
			n=sc.nextInt();
			int a[]=fillArr(n);	
			Arrays.sort(a);
			j=n-1;i=0;
			k=a[c];
			while(i<j) {
				if(a[i]+a[j]==k) {
					flag=1;
					break;
				}
				if(a[i]+a[j]<k)
					i++;
				if(a[i]+a[j]>k)
					j--;
			}
			if(flag==1) {
			 fillArr(n);
			}
			for(int item: a)
				System.out.print(item+" ");
			System.out.println();
		}
		
		sc.close();
	}
	static int[] fillArr(int n) {
		int i;
		int arr[]=new int[n];
		for(i=0;i<n;i++) 
			arr[i]= (int)(Math.random() * (1000 - 1 + 1) + 1);
		
		return arr;
	}
}

