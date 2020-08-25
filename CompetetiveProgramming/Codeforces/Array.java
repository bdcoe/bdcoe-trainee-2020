
import java.util.*;
import java.util.Collections;

public class Array
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,flag=0;

		n=sc.nextInt();
		int arr[]=new int[n];
		
		List<Integer> listpos=new ArrayList<>();
		List<Integer> listneg=new ArrayList<>();
		List<Integer> list0=new ArrayList<>();
		
		for(i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		for(i=0;i<n;i++) {
			if(arr[i]==0)
				list0.add(arr[i]);
			if(arr[i]>0)
				listpos.add(arr[i]);
			if(arr[i]<0)
				listneg.add(arr[i]);
		}
		System.out.println("1 "+listneg.get(0));
		if(listpos.size()==0 && listneg.size()>2) {
		System.out.println("2 "+listneg.get(1)+" "+listneg.get(2));
		flag=1;
		}
		else
			System.out.println("1 "+listpos.get(0));
		
		if(flag==1) {
			System.out.print(listneg.size()-3+list0.size()+" ");
			for(i=3;i<listneg.size();i++)
				System.out.print(listneg.get(i)+" ");
			for(i=0;i<list0.size();i++)
				System.out.print(list0.get(i)+" ");
			System.out.println();
		}
		else
		{
			System.out.print(listneg.size()-1+listpos.size()-1+list0.size()+" ");
			for(i=1;i<listneg.size();i++)
				System.out.print(listneg.get(i)+" ");
			for(i=1;i<listpos.size();i++)
				System.out.print(listpos.get(i)+" ");
			for(i=0;i<list0.size();i++)
				System.out.print(list0.get(i)+" ");
			System.out.println();
		}
		
		sc.close();
	}
}
