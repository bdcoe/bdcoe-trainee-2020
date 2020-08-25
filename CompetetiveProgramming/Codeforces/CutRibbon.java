/*
 * DP OR aX+bY+cZ=n
 */
import java.util.*;
import java.util.Collections;

public class CutRibbon
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,a,b,c,i,j,k,ans=-1,temp=0;
		
		
		n=sc.nextInt();
		a=sc.nextInt();
		b=sc.nextInt();
		c=sc.nextInt();
		
	
		for(i=n;i>=0;i--) {
			for(j=n;j>=0;j--) {
				if((n-(i*a+j*b))%c==0) {
				k=(int)((n-(i*a+j*b))/c);
				if(k>=0) {
				temp=i+j+k;
				ans=Math.max(temp, ans);
				}
				}
			}
		}
			
		System.out.println(ans);

		sc.close();
	}
}

