
import java.util.*;
import java.util.Collections;

public class PoliceRecruits
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,pol=0,crime=0;
		
		n=sc.nextInt();
		int arr[]=new int[n];
		for(i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		for(i=0;i<n;i++) {
			if(arr[i]==-1) {
				crime++;
				if(pol>0) {
					pol--;
					crime--;
				}
			}
			else 
				pol+=arr[i];		
		}
		System.out.println(crime);

		sc.close();
	}
}

