import java.util.Scanner;

public class PopGates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc=new Scanner(System.in);
		
		int n,t,i,m,j,count,k;
		count=0;
		char p;
		t=sc.nextInt();
		while(t-->0) {
			n=sc.nextInt();
			k=sc.nextInt();
			
			char a[]=new char[n];
			for(i=0;i<n;i++) {
				p=sc.next().charAt(0);
				a[i]=p;
			}
			
			
				for(j=n-1;j>=n-k;j--) 
				{
					if(a[j]=='H')
					{
							for(m=0;m<=j;m++) {
								if(a[m]=='H')
									a[m]='T';
								else
									a[m]='H';
							}
					}
					
				}
			for (i=0;i<n-k;i++) {
				if(a[i]=='H')
					count++;
			}
			System.out.println(count);
			count=0;
		
		}
		sc.close();
		
	}

}
