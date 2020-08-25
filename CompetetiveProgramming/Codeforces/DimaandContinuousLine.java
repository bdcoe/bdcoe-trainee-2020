
import java.io.*; 
import java.util.*; 


public class DimaandContinuousLine
{

	public static void main(String args[])
	{
		
		FastReader sc= new FastReader();
		PrintWriter out = new PrintWriter(System.out);

		int t,n,i,j,min,max;
		String s;

		n=sc.nextInt();
		int arr[]=sc.readArray(n);
		int flag=0;
		for(i=0;i<n-2;i++) {
			min=Math.min(arr[i], arr[i+1]);
			max=Math.max(arr[i], arr[i+1]);
			for(j=i+1;j<n-1;j++) {
				int mintemp=Math.min(arr[j],arr[j+1]);
				int maxtemp=Math.max(arr[j],arr[j+1]);
				
				if((mintemp<min && maxtemp<max && maxtemp>min) || (mintemp<max && maxtemp>max && mintemp>min)) {
					flag=1;
					break;
				}
			}
			if(flag==1)
				break;
		}
		if(flag==1)
		out.println("yes");
		else
			out.println("no");

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
