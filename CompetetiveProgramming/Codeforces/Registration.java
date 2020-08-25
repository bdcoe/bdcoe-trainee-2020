import java.util.Arrays;
import java.util.Scanner;

public class Registration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		
		int n,j,i,count;
		count=1;
		
		
		n=sc.nextInt();
		String a[]=new String[n];
	
		boolean visited[]=new boolean[n];
		
		Arrays.fill(visited, false);
		
		for(i=0;i<n;i++) {
			a[i]=sc.next();
		}
		
		for(i=0;i<n;i++) {
			for(j=i+1;j<n;j++) {
				if(visited[i]==false) {
					if(a[j].equals(a[i])) {
						a[j]=a[j]+Integer.toString(count);
						count++;
						visited[j]=true;
					}
				}
			}
			count=1;
		}
		
		for(i=0;i<n;i++) {
			if(visited[i]==false)
				a[i]="OK";
		}
		
		for(String item : a) {
			System.out.println(item);
		}
		sc.close();
	}

}
