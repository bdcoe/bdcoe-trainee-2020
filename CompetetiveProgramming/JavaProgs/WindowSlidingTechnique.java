/*
 * FIND THE MAXIMUM SUM OF SUBARRAY OF SIZE K USING WINDOW SLIDING TECHNIQUE
 * 
 * */
import java.io.*; 
import java.util.*; 


public class WindowSlidingTechnique
{

	public static void main(String args[])
	{
		
		FastReader sc= new FastReader();
		PrintWriter out = new PrintWriter(System.out);

		int k,n,i,j;
		String s;

		n=sc.nextInt();
		k=sc.nextInt();
		int arr[]=sc.readArray(n);
		
		int maxsum = windowSliding(arr,n,k);
		out.println(maxsum);

		out.close();
	}
	
	public static int windowSliding(int arr[],int n,int k) {
		int i,currsum,res,j;
		currsum=0;
		res=Integer.MIN_VALUE;
		for(i=0;i<k;i++) {
			currsum+=arr[i];
			res=Math.max(currsum, res);
		}
		for(i=k;i<n;i++) {
			currsum+=(arr[i]-arr[i-k]);
			res=Math.max(res,currsum);
			}
		
		return res;
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
