import java.util.Arrays;
import java.util.Scanner;

public class CARSELL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int n,i,t,count,temp;
		long mod,ans;
		ans=0;count=0;
		mod=(long)Math.pow(10,9)+7;
		
		t=sc.nextInt();
		
		while(t-->0) {
			n=sc.nextInt();
			int a[]=new int[n];
			for(i=0;i<n;i++) {
				a[i]=sc.nextInt();
			}
			
			Arrays.sort(a);
			
			for(i=n-1;i>=0;i--) {
				
				if(a[i]!=0) {
				temp=a[i]-count;
				if(temp<=0) {
					ans+=0;
				}
				else
					ans+=temp;
				}
				else {
					ans+=0;
				}
				count++;
			}
			System.out.println(ans%mod);
			count=0;
			ans=0;	
		}
		
		sc.close();
	}

}
