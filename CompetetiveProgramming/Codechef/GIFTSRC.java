import java.util.Scanner;

public class GIFTSRC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		
		int n,t,i,x,y,flag1,flag2;
		String s;
		x=y=flag1=flag2=0;
		t=sc.nextInt();
		while(t-->0) {
			n=sc.nextInt();
			sc.nextLine();
			s=sc.nextLine();
			
			for(i=0;i<n;i++) {
				char p=s.charAt(i);
				if(p=='L' && flag1==0) {
					x=x-1;
					flag1=1;
					flag2=0;
				}
				if(p=='R' && flag1==0) {
					x=x+1;
					flag1=1;
					flag2=0;
				}
				if(p=='U' && flag2==0) {
					y=y+1;
					flag2=1;
					flag1=0;
					
				}
				if(p=='D' && flag2==0) {
					y=y-1;
					flag2=1;
					flag1=0;
				}
				
			}
			System.out.println(x+" "+y);
			x=y=flag1=flag2=0;
		}
		sc.close();
	}

}
