import java.util.Scanner;

public class TWOVSTEN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc= new Scanner(System.in);
		int n,x,counter;
		counter=0;
		n=sc.nextInt();
		
		for(int i=1;i<=n;i++) 
		{
			x=sc.nextInt();
		
			if(x%10 == 0) {
				counter=0;}
			else
			{
				do {
				x=x*2;
				counter++;
					}while(x%10!=0 && x<=(int)Math.pow(10, 9));
				if(x%10!=0) {
					counter=-1;}
			
			}
			System.out.println(counter);
			counter=0;
		}
		
		sc.close();

	}

}
