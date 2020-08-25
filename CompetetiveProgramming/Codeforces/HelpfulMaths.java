
import java.util.*;
import java.util.Collections;

public class HelpfulMaths
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int i,j;
		String s,ans;
		j=0;
		ans="";

		s=sc.nextLine();
		
		int arr[]=new int[(int)Math.ceil(s.length()/2.0)];
		for(i=0;i<s.length();i+=2) {
			char p=s.charAt(i);
			arr[j]=Integer.parseInt(String.valueOf(p));
			j++;
		}
		Arrays.sort(arr);
		
		for(i=0;i<arr.length;i++)
			ans=ans+Integer.toString(arr[i])+"+";
		
		System.out.println(ans.substring(0,ans.length()-1));

		sc.close();
	}
}
