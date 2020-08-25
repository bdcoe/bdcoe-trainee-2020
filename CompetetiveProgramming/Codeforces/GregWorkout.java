
import java.util.*;
import java.util.Collections;

public class GregWorkout
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,chest=0,bis=0,back=0,max;

		n=sc.nextInt();
		int arr[]=new int[n];
		
		for(i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		for(i=0;i<n;i++) {
			if(i%3==0)
				chest+=arr[i];
			if(i%3==1)
				bis+=arr[i];
			if(i%3==2)
				back+=arr[i];
		}
		
		max=chest > (bis > back ? bis : back) ? chest : ((bis > back) ? bis :back);
		
		if(max==chest)
		System.out.println("chest");
		else if(max==bis)
			System.out.println("biceps");
		else
			System.out.println("back");

		sc.close();
	}
}

