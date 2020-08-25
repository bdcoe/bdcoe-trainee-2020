import java.util.Scanner;

public class LIFTIME {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int i,temp,x,t,n,q,f,d,count;
		count=x=0;
		t=sc.nextInt();
		
		while(t-->0) {
			
			n=sc.nextInt();
			q=sc.nextInt();
			
			for(i=1;i<=q;i++) {
				f=sc.nextInt();
				temp=Math.abs(x-f);
				d=sc.nextInt();	
				if(i==1) {
					count+=Math.max(f, d);
					x=d;
					if(d<f)
					count+=Math.abs(d-f);
				}
				else {
					count+=temp+Math.abs(d-f);
					x=d;
				}
			}
		
		System.out.println(count);
		count=0;
		}
sc.close();
	}

}
