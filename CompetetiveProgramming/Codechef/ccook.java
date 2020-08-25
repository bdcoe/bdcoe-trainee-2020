import java.util.Scanner;
public class ccook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int n,i,c;
		c=0;
		n=sc.nextInt();
		int arr[]=new int[5];
		
		while(n-->0) {
			for(i=0;i<5;i++) {
				arr[i]=sc.nextInt();
			}
			
			for(i=0;i<5;i++) {
				if(arr[i]==1)
					c++;
			}
			switch(c) {
			case 0:
				System.out.println("Beginner");
				break;
			case 1:
				System.out.println("Junior Developer");
				break;
			case 2:
				System.out.println("Middle Developer");
				break;
			case 3:
				System.out.println("Senior Developer");
				break;
			case 4:
				System.out.println("Hacker");
				break;
			case 5:
				System.out.println("Jeff Dean");
				break;
			}
			
			c=0;
		}
		
sc.close();
	}

}
