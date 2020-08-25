
import java.util.*;
import java.util.Collections;

public class ADAKING
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,n,r,c;
		t=sc.nextInt();
		String arr[][]=new String[8][8];
		while(t-->0) {
			n=sc.nextInt();
			arr[0][0]="O";
			n--;
			
			
			for(r=0;r<8;r++) {
				for(c=0;c<8;c++) {
					
					//if((r-c)*(r-c)<=2)
					//break;
					//n=(n*(n-1)/2)%8;
					if(r==0 && c==0)
						continue;
					if(n>0) {
						arr[r][c]=".";
						n--;
					}
					else
						arr[r][c]="X";
				}
			}
			
			for(r=0;r<8;r++) {
				for(c=0;c<8;c++) {
					System.out.print(arr[r][c]);
				}
				System.out.println();
			}
			
		}
		
		sc.close();
	}
}

