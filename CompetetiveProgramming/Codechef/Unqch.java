import java.util.Scanner;

public class Unqch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc= new Scanner(System.in);
		
		int i,j,ans,flag,t;
		ans=flag=0;
		String str;
		char p,q;
		t=sc.nextInt();
		
		while(t-->0) {
			str=sc.next();
		int len=str.length();
		
		for(i=0;i<len;i++) {
			p=str.charAt(i);
			for(j=0;j<len;j++)
			{
				if(j==i) {
					continue;
				}
			q=str.charAt(j);
			if(p!=q) {
				flag=0;
				}
			else {
					flag=1;
					break;
			}
			}
			if(flag==0) {
				ans=i;
				System.out.println(ans);
				break;
			}	
		}
		if(flag==1) {
			System.out.println("-1");
		}
		}
		sc.close();
	}

}
