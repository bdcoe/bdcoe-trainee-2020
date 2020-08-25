
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer;

public class CHEFNWRK
{

	public static void main(String args[])
	{
		
		FastReader sc= new FastReader();

		int t,n,i,j,k;
		String s;

		t=sc.nextInt();
		while(t-->0) {
		n=sc.nextInt();
		k=sc.nextInt();
			int arr[]=new int[n];
			
			for(i=0;i<n;i++) 
				arr[i]=sc.nextInt();
			int sum=arr[0],count=1,flag=0;
			if(arr[0]>k) {
				System.out.println("-1");
				continue;
			}
			for(i=1;i<n;i++) {
				
				if(arr[i]>k) {
					flag=1;
					break;
				}else {
				if(arr[i]+sum<=k) {
					sum+=arr[i];
					continue;
				}
				
				else {
					count++;
					sum=0;
					i--;
				}
				}
			}
			if(flag==1)
				System.out.println("-1");
			else
			System.out.println(count);
		}
		
	}
	




	/*
		FASTREADER
	*/
	static class FastReader 
    	{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } }
