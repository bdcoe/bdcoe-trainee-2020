
import java.util.*;
import java.util.Collections;

public class CRDGAME3
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int t,chef,rick,chefdig,rickdig;
		

		t=sc.nextInt();
		while(t-->0) {
			chef=sc.nextInt();
			rick=sc.nextInt();
			
			chefdig=(int)Math.ceil(chef/9.0);
			rickdig=(int)Math.ceil(rick/9.0);
			
			if(chefdig<rickdig)
				System.out.println("0 "+chefdig);
			if(chefdig==rickdig)
				System.out.println("1 "+chefdig);
			if(chefdig>rickdig)
				System.out.println("1 "+rickdig);
		}

		sc.close();
	}
}
