/*
 * MAJOTITY ELEMENT (ELEMENT OCCURING MORE THAN N/2 TIMES)
 * 
 *  USING MOORE'S VOTING ALGORITHM
 * */
import java.io.*; 
import java.util.*; 


public class MajorityElement
{

	public static void main(String args[])
	{
		
		FastReader sc= new FastReader();
		PrintWriter out = new PrintWriter(System.out);

		int t,n,i,j;
		String s;

		n=sc.nextInt();
		int arr[]=new int[n];
		
		for(i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
		int res=Moorey(arr);
		int count=0;
		
		for(i=0;i<n;i++) {
			if(arr[res]==arr[i])
				count++;
		}
		
		if(count>n/2)
		out.println("Majority element index = "+res+" Majority element = "+arr[res]);
		else
			out.println("No majority element");

		out.close();
	}
	
	public static int Moorey(int arr[]) {
		int count=1,res=0,i;
		
		for(i=1;i<arr.length;i++) {
			if(arr[res]==arr[i])
				count++;
			else
				count--;
			
			if(count<0) {
				res=i;
				count=1;
			}
		}
		return res;
	}




	/*
		FASTREADER
	*/	static class FastReader 
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
