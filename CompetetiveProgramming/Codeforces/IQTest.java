
import java.util.*;
import java.util.Collections;

public class IQTest
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,cev=0,codd=0,pos=0;
	

		n=sc.nextInt();
		int arr[]=new int[n];
		
		for(i=0;i<n;i++) {
			arr[i]=sc.nextInt();
			if((arr[i]&1)==1)
				codd++;
			else
				cev++;
		}
		
		if(cev>codd) {
			for(i=0;i<n;i++) {
				if(arr[i]%2!=0) {
					pos=i;break;
				}
			}
		}
		if(cev<codd) {
			for(i=0;i<n;i++) {
				if(arr[i]%2==0) {
					pos=i;break;
				}
			}
		}
		
		System.out.println(pos+1);

		sc.close();
	}
}

