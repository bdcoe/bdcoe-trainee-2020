
import java.util.*;
import java.util.Collections;

public class CollectingBeatsIsFun
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,j,k,count=0,flag=0;
		

		n=sc.nextInt();
		char arr[][]=new char[4][4];
		
		for(i=0;i<4;i++)
			arr[i]=sc.next().toCharArray();
		
		for(i=1;i<=9;i++) {
			count=0;
			for(j=0;j<4;j++) {
				for(k=0;k<4;k++) {
					if(arr[j][k]=='.')
						continue;
					if(Integer.parseInt(String.valueOf(arr[j][k]))==i)
						count++;
				}
			}
			if(count>2*n) {
				flag=1;
				break;
			}
				if(flag==1)
					break;
		}
		if(flag==1)
		System.out.println("NO");
		else
			System.out.println("YES");

		sc.close();
	}
}
