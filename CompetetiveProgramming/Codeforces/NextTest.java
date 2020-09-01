

import java.io.*; 
import java.util.*; 


public class NextTest
{

	public static void main(String args[])
	{
		
		FastReader sc= new FastReader();
		PrintWriter out = new PrintWriter(System.out);

		int t,n,i,flag=0;
		String s;
		int ans=0;
		n=sc.nextInt();
		int arr[]=sc.readArray(n);
		
		Arrays.parallelSort(arr);
		for(i=1;i<=n;i++) {
			ans=arr[i-1]^i;
			if(ans!=0) {
				flag=1;
				out.println(i);
				break;
			}
		}
		if(flag==0)
			out.println(n+1);
		out.close();
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
	
		/*DEFINED BY ME
		*/
		int[] readArray(int n){
			
			int arr[]=new int[n];
			
			for(int i=0;i<n;i++)
				arr[i]=nextInt();
			
			return arr;
		}
    } 
}
