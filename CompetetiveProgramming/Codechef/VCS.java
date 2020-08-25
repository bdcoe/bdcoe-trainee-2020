import java.util.Scanner;

public class VCS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		
		int t,nsf,nif,ntf,i,j,count;
		count=0;
		t=sc.nextInt();
		
		
			
		while(t>0) {
			t--;
			nsf=sc.nextInt();
			nif=sc.nextInt();
			ntf=sc.nextInt();
			
			int ignored[]=new int[nif];
			int tracked[]=new int[ntf];
		
			//filling ignored files
			for(j=0;j<nif;j++) {
				ignored[j]=sc.nextInt();
			}
			//filling tracked files
			
			for(j=0;j<ntf;j++) {
				tracked[j]=sc.nextInt();
			}
			
			for(i=0;i<nif;i++) {
				for(j=0;j<ntf;j++) {
					if(ignored[i]==tracked[j]) {
				count++;
				break;
					}
				}
			}
			
			int ans = nsf-(nif+ntf-count);
			System.out.println(count+" "+ans);
			count=0;
			ans=0;
		}
		
			
		
		sc.close();
		
	}

}
