/*
 * 
 * NOT COMPLETED
 * */
import java.io.*; 
import java.util.*; 


public class PointOnSpiral
{

	public static void main(String args[])
	{
		
		FastReader sc= new FastReader();
		PrintWriter out = new PrintWriter(System.out);

		int x,y,i,j;
		String s;

		x=sc.nextInt();
		y=sc.nextInt();
		
		int max=Math.max(Math.abs(x), Math.abs(y));
		int count=(max-1)*4;
		
		if(x>0 && y>0 && x==y)
			out.println(count+1);
		if(x<0 && y<0 && x==y)
			out.println(count+3);
		if(x<0 && y>0 )
			out.println(count+2);
		if(x>0 && y<0)
			out.println(count);
		
		
		out.println();

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
