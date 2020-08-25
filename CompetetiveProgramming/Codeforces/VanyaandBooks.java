import java.util.Scanner;

public class VanyaandBooks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		
		int i,len;
		
		long ans,n;
		String s;
		ans=0;
		n=sc.nextLong();
		long a[]=new long[13];
		for(i=1;i<13;i++) {
			a[i]=9*(long)Math.pow(10, i-1);
		}
		s=Long.toString(n);
		len=s.length();
		
		for(i=1;i<=len;i++) {
			if(n-a[i]>=0) {
				ans+=a[i]*i;
				n=n-a[i];
			}
			else
				ans+=n*i;
		}
		
		System.out.println(ans);	
		sc.close();
	}

}
