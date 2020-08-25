
import java.util.*;
import java.util.Collections;

public class GrandfathersDovletCalculator
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int a,b,i,dig,temp,count=0;
		
		a=sc.nextInt();
		b=sc.nextInt();
		int arr[]= {6,2,5,5,4,5,6,3,7,6};
		
		for(i=a;i<=b;i++) {
			temp=i;
			while(temp>0) {
				dig=temp%10;
				count+=arr[dig];
				temp/=10;
			}
		}
		System.out.println(count);
		sc.close();
	}
}
