
import java.util.*;
import java.util.Collections;

public class ApplemanandEasyTask
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,n,i,j,count=0;

		n=sc.nextInt();
		char arr[][]=new char[n][n];
		
		
		for(i = 0; i < n; i++)
				arr[i] = sc.next().toCharArray();
			
		for(i = 0; i < n; i++) {
			for(j = 0; j < n; j++){
				count= 0;
				
				//left...
				if((j > 0) && (arr[i][j-1] == 'o')){
					count++;
				}
				// top
				if((i > 0) && (arr[i-1][j] == 'o'))
					count++;
				// right;
				if((j < n-1) && (arr[i][j+1] == 'o'))
					count++;
				// down..
				if((i < n-1) && (arr[i+1][j] == 'o'))
					count++;
				
				if(count == 1 || count == 3){
					break;
				}
			}
			if(count ==  1 || count == 3)
				break;
		}
		if(count == 1 || count == 3)
			System.out.println("NO");
		else
			System.out.println("YES");
		
		sc.close();
	}
}

