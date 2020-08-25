import java.util.Scanner;

public class Watermelon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int n;
		n=sc.nextInt();
		
		if(n%2==0 && n!=2)
			System.out.println("YES");
		else
			System.out.println("NO");
		sc.close();
		

	}

}
