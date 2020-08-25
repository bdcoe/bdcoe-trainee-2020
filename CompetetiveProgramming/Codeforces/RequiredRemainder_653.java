import java.util.Scanner;

public class RequiredRemainder_653 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		int t;
		long x,y,n,k,ans;
		ans=0;
		
		t=sc.nextInt();
		
		while(t-->0) {
			x=sc.nextLong();
			y=sc.nextLong();
			n=sc.nextLong();
			
			for(k=n;k>=0;k--) {
				if(k%x==y) {
				ans=k;
					break;
				}
			}
			System.out.println(ans);
		}
		sc.close();

	}

}
