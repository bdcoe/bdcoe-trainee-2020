/*
 * FILE HANDLING 
 * WA
 * */
import java.io.*; 
import java.util.*; 

public class LeftHandersandRightHanders
{

	public static void main(String args[])throws IOException
	{
		
		Scanner sc= new Scanner(new File("input.txt"));
		PrintWriter out = new PrintWriter(new File("output.txt"));

		int t,n,i,j;
		String s;

		n=sc.nextInt();
		s=sc.nextLine();
		char arr[]=s.toCharArray();
		if(s.length()==4) {
			for(i=0;i<s.length()-2;i++) {
				if(arr[i]=='R' && arr[i+2]=='L') 
					out.println((i+3)+" "+(i+1));
				else
					out.println((i+1)+" "+(i+3));
			}
		}
		else {
		for(i=0;i<s.length()-3;i++) {
			if(arr[i]=='R' && arr[i+3]=='L') 
				out.println((i+4)+" "+(i+1));
			else
				out.println((i+1)+" "+(i+4));
		}
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
