//TLE

import java.util.*;
import java.util.Collections;

public class SUBSFREQ
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,n,i,j,k,count,l;

		long mod = (long)Math.pow(10, 9)+7;
	
		t=sc.nextInt();
		
		while(t-->0) {
			List<Integer> list=new ArrayList<>();
			List<Integer> ans=new ArrayList<>();
			int element=0;
			long c=0;
			
			n=sc.nextInt();
			int arr[]=new int[n+1];
			
			for(i=1;i<=n;i++) 
				arr[i]=sc.nextInt();
			
			
			for(int counter=1;counter<Math.pow(2, n);counter++) {
				
				for(j=1;j<=n;j++) {
					
					if((counter & (1<<j-1))!=0) {
						list.add(arr[j]);
					}
					
				}
				count=Integer.MIN_VALUE;
				
				for(k=0;k<list.size();k++) {
					int temp=0;
					for(l=0;l<list.size();l++) {
						if(list.get(k)==list.get(l))
							temp++;
					}
					if(temp==count) {
						if(list.get(k)<element)
							element=list.get(k);
					}
					if(temp>count) {
						count=temp;
						element=list.get(k);
					}
					
				}
				ans.add(element);
				
				list.clear();
			}
			
			for(i=1;i<=n;i++) {
				c=0;
				for(j=0;j<ans.size();j++) {
					if(ans.get(j)==i)
						c++;
				}
				System.out.print(c%mod+" ");
			}
			System.out.println();
		}
		
		sc.close();
	}
}
