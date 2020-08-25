
import java.util.*;
import java.util.Collections;

public class MinimumDifficulty
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,j,ans=Integer.MAX_VALUE,temp;

		n=sc.nextInt();
		
		int arr[]=new int[n];
		boolean visited[]=new boolean[n];
		
		List<Integer> list = new ArrayList<>();
		
		for(i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		for(i=1;i<n-1;i++) {
			visited[i]=true;
			temp=Integer.MIN_VALUE;
			for(j=0;j<n;j++) {
				if(visited[j]==false)
					list.add(arr[j]);
			}
			for(j=0;j<list.size()-1;j++) {
					int diff=list.get(j+1)-list.get(j);
					temp=Math.max(temp,diff);
			}
			ans=Math.min(ans, temp);
			list.clear();
			visited[i]=false;
		}
		
		System.out.println(ans);

		sc.close();
	}

}
