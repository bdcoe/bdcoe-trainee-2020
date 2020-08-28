import java.util.Scanner;

public class SelectionSort {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n,temp;
		
		System.out.println("Enter number of elements");
		n=sc.nextInt();
		
		int a[]=new int [n];
		System.out.println("Enter elements");
		
		for(int i =0;i<n;i++)
			a[i]=sc.nextInt();
		
		for(int i=0; i<n-1 ;i++) 
		{
			int minind=i;
			for(int j=i;j<n;j++)
			{
				if(a[j]<a[minind]) {
					minind=j;
					}
					temp=a[i]; 
					a[i]=a[minind];
					a[minind]=temp;		
				}
			}
		
		for(int item: a) {
			System.out.print(item+" ,");	
		}
		sc.close();
	}		
}

