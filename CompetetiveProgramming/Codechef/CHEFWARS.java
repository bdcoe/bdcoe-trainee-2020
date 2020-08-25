
import java.util.*;
import java.util.Collections;

public class CHEFWARS
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,p,h,chef,darth;

		t=sc.nextInt();
		
		while(t-->0) {
		h=sc.nextInt();
		p=sc.nextInt();
		chef=0;darth=0;
		while(true) {
			h-=p;
			p=p>>1;
			if(h<=0) {
				chef=1;
				break;
			}
			if(p<=0) {
				darth=1;
				break;
			}
				
		}
		if(chef==1)
			System.out.println("1");
		if(darth==1)
			System.out.println("0");
		
		}
		
		sc.close();
	}
}
