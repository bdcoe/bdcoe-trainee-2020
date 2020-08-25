
import java.util.*;
import java.util.Collections;

public class IWannaBeTheGuy
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,j,x,y,k,flag=0,flag2=0,flag3=0;
		

		n=sc.nextInt();
		x=sc.nextInt();
		int arr[]=new int[x];
		for(i=0;i<x;i++)
			arr[i]=sc.nextInt();
		
		y=sc.nextInt();
		int b[]=new int[y];
		for(i=0;i<y;i++)
			b[i]=sc.nextInt();
		
		for(i=1;i<=n;i++) {
			for(j=0;j<x;j++) {
				if(arr[j]==i) {
					flag=1;
					break;
				}
			}
			if(flag!=1) {
				for(k=0;k<y;k++) {
					if(b[k]==i) {
						flag2=1;
						break;
					}
				}
			}
			if(flag==0 && flag2==0) {
				flag3=1;
				break;
			}
			flag=flag2=0;
		}
		if(flag3==1)
		System.out.println("Oh, my keyboard!");
		else
			System.out.println("I become the guy.");
		

		sc.close();
	}
}

