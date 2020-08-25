
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer;

public class LineToCashier
{

	public static void main(String args[])
	{
		
		FastReader sc= new FastReader();

		int k,n,i,j,minT=Integer.MAX_VALUE;
		String s;

		n=sc.nextInt();
		int b[]=new int[n];
		
		for(j=0;j<n;j++) 
		b[j]=sc.nextInt();
		
		for(j=0;j<n;j++) {
			
		int arr[]=new int[b[j]];
		
		for(i=0;i<b[j];i++)
			arr[i]=sc.nextInt();
		
		 int temp=0;
		
		for(i=0;i<b[j];i++) 
			temp+=arr[i]*5;
		
		temp+=b[j]*15;
		
		minT=Math.min(temp, minT);
		
		}
		System.out.println(minT);
	
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
    } 
}
