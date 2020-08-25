import java.util.Scanner;

public class COVIDLQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		Scanner sc=new Scanner(System.in);
		
		int n,j,i,t,dis,flag,count,lol=0;
		flag=count=dis=0;
		
		t=sc.nextInt();
		while(t-->0) {
			
			n=sc.nextInt();
			int a[]=new int[n];
			for(i=0;i<n;i++) {
				a[i]=sc.nextInt();
			}
			
			for(i=0;i<n;i++) {
				if(a[i]==1)
					lol++;
			}
			
			if(n<=6) {
				for(i=0;i<n;i++) {
					if(a[i]==1)
						count++;
				}
				if(count>1)
					System.out.println("NO");
				else
					System.out.println("YES");
				count=0;
			}
			
			
			if(n>6 && lol==1) {
				System.out.println("YES");
			}
			
			
			
			
			if(n>6 && lol>1) {
			for(i=0;i<n;i++) 
			{
				if(a[i]==1)
				{
				for(j=i+1;j<n;j++)
				{
					if(a[j]==1) {
						dis=j-i;
					break;	
					}
				
				}
				if(dis<6) {
					System.out.println("NO");
					flag=1;
					break;
				}
			}		
			}
			
			if(flag==0) {
				System.out.println("YES");
				}
			flag=0;
			
		}
		lol=0;
	}
		sc.close();
}
}