import java.util.Scanner;

public class Team {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		Scanner sc=new Scanner(System.in);
		
		int i,n,temp=0,count=0;
		n=sc.nextInt();
		
		int a[]=new int[3];
		
		while(n-->0) {
			for(i=0;i<3;i++)
				a[i]=sc.nextInt();
			for(i=0;i<3;i++) {
				if(a[i]==1)
					temp++;
			}
			if(temp>=2)
				count++;
			temp=0;
		}
		System.out.println(count);
		sc.close();
	}

}
