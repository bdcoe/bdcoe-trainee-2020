
import java.util.*;
import java.util.Collections;

public class YoungPhysicist
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,j,flag=0;
		

		n=sc.nextInt();
		int arr[]=new int[3];
		int b[]=new int[3];
		
		for(i=1;i<=n;i++) {
			for(j=0;j<3;j++) {
				arr[j]=sc.nextInt();
				b[j]+=arr[j];
			}
		}
		for(i=0;i<3;i++) {
			if(b[i]!=0) {
				flag=1;
				break;
			}
		}
		if(flag==1)
		System.out.println("NO");
		else
			System.out.println("YES");

		sc.close();
	}

}
