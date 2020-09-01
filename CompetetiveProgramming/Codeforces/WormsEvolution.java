
import java.io.*; 
import java.util.*; 


public class WormsEvolution
{

	public static void main(String args[])
	{
		
		FastReader sc= new FastReader();
		PrintWriter out = new PrintWriter(System.out);

		int t,n,i,j,k;
		
		n=sc.nextInt();

		int res=0;
		int arr[]=sc.readArray(n);
		int sum=0;
		for(i=0;i<n;i++) {
			sum=arr[i];
			for(j=0;j<n;j++) {
				if(j==i)
					continue;
				for(k=0;k<n;k++) {
					if(k==i || k==j)
						continue;
					if(arr[j]+arr[k]==arr[i]) {
						res=1;
						out.println((i+1)+" "+(j+1)+" "+(k+1));
						break;
					}
				}
				if(res==1)
					break;
			}
			if (res==1)
				break;
		}
		
		if(res==0)
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
