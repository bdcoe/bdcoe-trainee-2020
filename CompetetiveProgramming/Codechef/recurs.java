

import java.util.*;
import java.util.Collections;

public class recurs
{
	 public static int recursion(int arr[], int i, int sum, int total) 
	 	{ 
		 if (i == 0) 
			 return Math.abs((total-sum)-sum); 
		 return Math.min(recursion(arr,i-1,sum+arr[i-1],total),recursion(arr,i-1,sum,total)); 
	 	} 


	 public static int givetotal(int arr[], int n) 
	 { 

		 int total = 0; 
		 for (int i = 0; i < n; i++) 
			total += arr[i]; 
		 return recursion(arr, n, 0,total); 
	 } 

	 	public static void main(String[] args)  
	 		{ 
	 		
	 		Scanner sc=new Scanner(System.in);
	 			int i;
	 			int n = sc.nextInt();
	 			int arr[]=new int[n];
	 			for(i=0;i<n;i++)
	 				arr[i]=sc.nextInt();
	 			
	 			System.out.print(givetotal(arr, n)); 
	 			
	 			sc.close();
} 
} 