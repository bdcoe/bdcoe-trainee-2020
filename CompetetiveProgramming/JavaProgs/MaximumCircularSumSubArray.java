
import java.io.*; 
import java.util.*; 


public class MaximumCircularSumSubArray
{

	public static void main(String args[])
	{
		
		FastReader sc= new FastReader();
		PrintWriter out = new PrintWriter(System.out);

		int t,n,i,j,sum=0;
		String s;

		n=sc.nextInt();
		int arr[]=new int[n];
		
		for(i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		int maxKad= Kadane(arr);
		int circKad=0;
		if(maxKad<0) 
		out.println(maxKad);
		else {
			for(i=0;i<n;i++) {
				sum+=arr[i];
				arr[i]=-arr[i];
			}
			circKad=Kadane(arr);
			int result=sum+circKad;
			out.println(Math.max(result,maxKad));
		}
		
		out.close();
		
	}
	
	public static int Kadane(int arr[]) {
		int count=0,i;
		int res=Integer.MIN_VALUE;
		
		for(i=0;i<arr.length;i++) {
			count+=arr[i];
			res=Math.max(count, res);
			
			if(count<0)
				count=0;
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
    } 
}
