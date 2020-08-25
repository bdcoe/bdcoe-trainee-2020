
import java.util.*;
import java.util.Collections;

public class Football
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,res;
		String ans="";

		n=sc.nextInt();
		sc.nextLine();
		String arr[]=new String[n];
		
		for(i=0;i<n;i++)
			arr[i]=sc.nextLine();
		
		Arrays.parallelSort(arr);
		res=1;
		ans=arr[0];
		i=0;
		while(i<arr.length-1) {
			int count=1;
			while(i<n-1 && arr[i+1].equals(arr[i])) {
				count++;
				i++;
			}
			if(count>res) {
				res=count;
				ans=arr[i];
			}
			i++;
		}
		
		System.out.println(ans);

		sc.close();
	}
}
