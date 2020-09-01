/*
 * WA
 * 
 * */
import java.io.*; 
import java.util.*; 


public class CowsAndPrimitiveRoots
{

	public static void main(String args[])
	{
		
		FastReader sc= new FastReader();
		PrintWriter out = new PrintWriter(System.out);

		int t,n,i,j;
		String s;

	
		n=sc.nextInt();
		checkPrime(n);
		

		out.close();
	}
	


	public static void checkPrime(int n) {
		boolean prime[]=new boolean[n+1];
		
		Arrays.fill(prime, true);
		prime[0]=prime[1]=false;
		 int count=0;
		for(int i=2;i<=Math.sqrt(n);i++) {
			for(int j=i*i;j<=n;j+=i) {
				prime[j]=false;
			}
		}
		
		for(int i=0;i<n;i++) {
			if(prime[i]==true)
				count++;;
		}
			System.out.println(count);
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
