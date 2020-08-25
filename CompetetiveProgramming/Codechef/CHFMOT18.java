import java.util.Scanner;

public class CHFMOT18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc=new Scanner(System.in);
		
		int n,s,t,count;
		count=0;
		t=sc.nextInt();
		
		while(t-->0) {
			s=sc.nextInt();
			n=sc.nextInt();
			if(s%2==1) {
				count++;
				s--;
			}
			
			while(true) {
				count+=s/n;
				s=s%n;
				n=s;
				if(n==0)
					break;
			}
			System.out.println(count);
			count=0;
		}
		sc.close();
	}

}
