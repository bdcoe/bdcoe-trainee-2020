
import java.util.*;
import java.util.Collections;

public class Presents
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,j;

		n=sc.nextInt();
		int arr[]=new int[n];
		
		for(i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		for(i=1;i<=n;i++) {
			for(j=0;j<arr.length;j++) {
				if(i==arr[j]) {
					System.out.print(j+1+" ");
					break;
				}
			}
		}
		sc.close();
	}
}

