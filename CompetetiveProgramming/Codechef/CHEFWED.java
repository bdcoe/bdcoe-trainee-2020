
import java.util.*;
import java.util.Collections;

public class CHEFWED 
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,n,i,k;
		
		t=sc.nextInt();
		
		while(t-->0) {
			n=sc.nextInt();
			k=sc.nextInt();
			int count=1,inefficient=0;
			int b[]=new int[101];
			
			int arr[]=new int[n];
			
			List<Integer> list = new ArrayList<>();
			
			for(i=0;i<n;i++)
				arr[i]=sc.nextInt();
			
			for(i=0;i<n;i++) {
				b[arr[i]]++;
				if(!list.contains(arr[i])) 
					list.add(arr[i]);
				
				else {
					count++;
					list.clear();
					list.add(arr[i]);
				}
			}
			for(i=0;i<b.length;i++) {
				if(b[i]>1)
					inefficient+=b[i];
			}
			int sum1=count*k;
			int sum2=inefficient+k;
			
			System.out.println(Math.min(sum1, sum2));
		}
		
		sc.close();
	}
}
