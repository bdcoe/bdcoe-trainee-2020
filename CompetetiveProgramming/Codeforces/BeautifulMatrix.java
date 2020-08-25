
import java.util.*;
import java.util.Collections;

public class BeautifulMatrix
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int r,c,i,j,count;
		count=r=c=0;
		int arr[][]=new int[5][5];
		
		for(i=0;i<5;i++) {
			for(j=0;j<5;j++)
				arr[i][j]=sc.nextInt();
		}
		
		for(i=0;i<5;i++) {
			for(j=0;j<5;j++) {
				if(arr[i][j]==1) {
					r=i;
					c=j;
					break;
				}
			}	
		}
		
		while(r!=2 || c!=2) {
			if(r>2) {
				count++;
				r--;
			}
			if(r<2) {
				count++;
				r++;
			}
			if(c>2) {
				count++;
				c--;
			}
			if(c<2) {
				count++;
				c++;
			}
		}
		
		System.out.println(count);

		sc.close();
	}
}

