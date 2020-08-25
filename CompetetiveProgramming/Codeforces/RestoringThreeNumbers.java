
import java.util.*;
import java.util.Collections;

public class RestoringThreeNumbers
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,a,b,c,p,q,r;
	
		int arr[]=new int[4];
		for(i=0;i<4;i++)
			arr[i]=sc.nextInt();
		
		Arrays.parallelSort(arr);
		a=arr[0];b=arr[1];c=arr[2];n=arr[3];
		
		p=(a+b-c)/2;
		q=a-p;
		r=b-p;
		
		System.out.println(p+" "+q+" "+r);

		sc.close();
	}
}

