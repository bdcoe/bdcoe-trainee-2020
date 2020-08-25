import java.util.Scanner;

public class atm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		int wt= sc.nextInt();
		float bal=sc.nextFloat();
		float tot;
		
		if(wt%5!=0 || wt+0.50>=bal)
		System.out.println(bal);
		else {
			tot=bal-wt-(float)0.5;
		System.out.println(String.format("%.2f",tot));	
		}
		sc.close();
		
		
		
		
	}

}
