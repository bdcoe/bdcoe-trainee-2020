
import java.util.*;
import java.util.Collections;

public class YarslovAndPermutations
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,x,flag=0;

		n=sc.nextInt();
		int arr[]=new int[n];
		
		for(i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		Arrays.parallelSort(arr);
		i=0;
		x=(int)Math.ceil(n/2.0);
		while(i<arr.length-1) {
			int count=1;
			while(i<n-1 && arr[i+1]==arr[i]) {
				count++;
				i++;
			}
			if(count>x) {
				flag=1;
				break;
			}
			i++;
		}
		
		if(flag==1)
		System.out.println("NO");
		else
			System.out.println("YES");

		sc.close();
	}
}
