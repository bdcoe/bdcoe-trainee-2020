
import java.io.*; 
import java.util.*; 


public class RookBishopKing
{

	public static void main(String args[])
	{
		
		FastReader sc= new FastReader();
		PrintWriter out = new PrintWriter(System.out);

		int r1,c1,r2,c2,i;
		String s;

		r1=sc.nextInt();
		c1=sc.nextInt();
		r2=sc.nextInt();
		c2=sc.nextInt();
		
		if(r1==r2 || c1==c2)
			out.print(1+" ");
		else
			out.print(2+" ");
		
		if((r1+c1)%2!=(r2+c2)%2)
			out.print(0+" ");
		else {
		if((r1+c1)==(r2+c2) || (r1-c1)==(r2-c2))
			out.print(1+" ");
		else
			out.print(2+" ");
		}
		
		out.println(Math.max(Math.abs(r1-r2),Math.abs(c1-c2)));
	
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
