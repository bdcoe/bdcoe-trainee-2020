import java.util.Scanner;

public class FFL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		Scanner sc=new Scanner(System.in);
		int i,j,n,cost,s,t,flag;
		flag=cost=0;
		t=sc.nextInt();
		while(t-->0) {
			n=sc.nextInt();
			s=sc.nextInt();
			int a[]=new int[n];
			int b[]=new int[n];
			
			for(i=0;i<n;i++)
				a[i]=sc.nextInt();
			for(i=0;i<n;i++)
				b[i]=sc.nextInt();
			
			for(i=0;i<n;i++) {
				if(b[i]==0) {
					for(j=0;j<n;j++) {
						if(b[j]==1) {
							cost=s+a[i]+a[j];
						if(cost<=100) {
							flag=1;
							break;
						}
						}
					}
				
					if(flag==1) {
						System.out.println("yes");
						break;
						}
				}
				
			}
			if(flag==0)
				System.out.println("no");
			cost=flag=0;
		}
		sc.close();
		
	}

}
