import java.util.Scanner;

public class Mult2Div6_653 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner sc=new Scanner(System.in);
		
		int t,flag;
		long n,count;
		count=flag=0;
		t=sc.nextInt();
		while(t-->0) {
			n=sc.nextLong();
			
			while(n!=2) {
				if(n==1) {
					flag=1;
					break;	
				}
				if(n>=(long)Math.pow(10, 9)) {
					flag=0;
					break;
				}
				
				if(n%6==0) 
				{
					n=n/6;
				count++;	
				}
				else {
					n=n*2;
					count++;
				}
				
					
			}
			if(flag==1)
				System.out.println(count);
			else {
				System.out.println("-1");
			}
			count=flag=0;
		}
sc.close();
	}

}
