
import java.util.*;
import java.util.Collections;

public class AmusingJoke
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int i,flag=0;
		String s,t,m;
		s=sc.nextLine();
		t=sc.nextLine();
		m=sc.nextLine();
		int arr[]=new int[256];
		int b[]=new int[256];
		for(i=0;i<s.length();i++) {
			char p =s.charAt(i);
			arr[(int)p]++;
		}
		
		for(i=0;i<t.length();i++) {
			char p =t.charAt(i);
			arr[(int)p]++;
		}
		
		for(i=0;i<m.length();i++) {
			char p =m.charAt(i);
			b[(int)p]++;
		}
		
		for(i=65;i<=90;i++) {
			if(arr[i]!=b[i]) {
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

