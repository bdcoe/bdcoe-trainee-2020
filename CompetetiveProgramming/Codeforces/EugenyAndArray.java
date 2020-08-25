
import java.io.*;
import java.util.*;

 
public class EugenyAndArray
{
 
	public static void main(String args[])
	{
		
		FastReader sc= new FastReader();
		PrintWriter w= new PrintWriter(System.out);
 
		int t,n,i,m,j;
		String s;
 
		   n=sc.nextInt();
		   m=sc.nextInt();
	       int plus=0,minus=0;
	       int arr[]=new int[n];
	       for( i=0;i<n;i++){
	          arr[i]=sc.nextInt();
	          if(arr[i]==1)
	              plus++;
	          else
	              minus++;
	       }
	       
	       for(i=0;i<m;i++){
	           int a=sc.nextInt();
	           int b=sc.nextInt();
	           if((b-a)%2==0)
	               w.println(0);
	           else {
	               int e=(b-a)+1;
	               e/=2;
	               if(plus>=e && minus>=e)
	                   w.println(1);
	               else
	                   w.println(0);
	           }
	       }
		w.close();
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