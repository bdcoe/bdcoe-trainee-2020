
import java.io.*; 
import java.util.*; 


public class JugglingLetters_666
{

	public static void main(String args[])
	{
		
		FastReader sc= new FastReader();
		PrintWriter out = new PrintWriter(System.out);

		int t,n,i,j;
		String s;

		t=sc.nextInt();
		
		
		while(t-->0) {
			
		n=sc.nextInt();
		String arr[]=new String[n];
		int a[]=new int[255];
		
		for(i=0;i<n;i++)
			arr[i]=sc.nextLine();
		
		for(i=0;i<n;i++) {
			for(j=0;j<arr[i].length();j++) {
				char p=arr[i].charAt(j);
				a[(int)p]++;
			}
		}
		int flag=0;
		
		for(i=97;i<=122;i++) {
		if(a[i]%n!=0) {
			out.println("NO");
			flag=1;
			break;
		}
		}
		if(flag==0)
		out.println("YES");

		}
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
