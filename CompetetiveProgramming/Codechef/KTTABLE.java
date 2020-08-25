import java.util.Scanner;

public class KTTABLE {

	public static void main(String[] args) {
		
		
		Scanner sc= new Scanner(System.in);

		int n= sc.nextInt();
		
		int moments,i,j,k, treq,counter,diff;
		counter=0;
		
		
		
			
		for( i=1;i<=n;i++) {
			int N=sc.nextInt();
			int A[]= new int[N];
			int B[]= new int[N];
			
			for(j=0;j<N;j++) {
				moments=sc.nextInt();
				 A[j]=moments;
				}
				
			for( k=0;k<N;k++) {
				treq=sc.nextInt();
				B[k]=treq;
			}
			
			for(j=0;j<N;j++) {
				if(j==0) {
					diff=A[0];}
				else {
					diff=A[j]-A[j-1];}
				
				if(B[j]<=diff) {
					counter++;
					diff=0;
				}
				}
			System.out.println(counter);
			counter=0;
			
		}
		
		sc.close();
		
	}

}
