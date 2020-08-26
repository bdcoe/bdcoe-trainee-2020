
import java.io.*; 
import java.util.*; 


public class Sockets
{

	public static void main(String args[])
	{
		
		FastReader sc= new FastReader();
		PrintWriter out = new PrintWriter(System.out);

		int t,k,m,n,i,count=0,sum=0,flag=0;
		String s;

		n=sc.nextInt();
		m=sc.nextInt();
		k=sc.nextInt();
		int arr[]=sc.readArray(n);
		Arrays.parallelSort(arr);
		
		i=arr.length-1;
		 while((m-k)>0 && i>=0){
	            if(k>0){
	                m-=arr[i];
	                k--;
	                count++;
	                i--;
	              
	            }
	            else if((m-k)>0 && k<=0){
	                m+=1;
	                m-=arr[i];
	                count++;
	                i--;
	            }
	        }
	        
	        if((m-k)<=0)
	        	out.println(count);
	        else 
	        	out.println(-1);
	        
	    
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
