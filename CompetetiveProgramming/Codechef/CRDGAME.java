
import java.util.*;
import java.util.Collections;

public class CRDGAME
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,n,chef,monty,cp,mp,dig;
		chef=mp=cp=mp=monty=0;
		int arr[]=new int[2];
		t=sc.nextInt();
		while(t-->0) {
			n=sc.nextInt();
			
			while(n-->0) {
				arr[0]=sc.nextInt();
				arr[1]=sc.nextInt();
				
				while(arr[0]>0) {
					dig=arr[0]%10;
					arr[0]/=10;
					chef+=dig;
				}
				while(arr[1]>0) {
					dig=arr[1]%10;
					arr[1]/=10;
					monty+=dig;
				}
				if(chef>monty) 
					cp++;
				else if(chef==monty) 
				{
					mp++;cp++;
					}
				else
					mp++;
				
					chef=monty=0;
			}
			if(cp>mp)
				System.out.println("0 "+cp);
			if(mp>cp)
				System.out.println("1 "+mp);
			if(cp==mp)
				System.out.println("2 "+cp);
			chef=mp=cp=mp=monty=0;
		}
		
		sc.close();
	}
}

