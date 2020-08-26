
import java.io.*; 
import java.util.*; 


public class PalindromicTimes
{

	public static void main(String args[])
	{
		
		FastReader sc= new FastReader();
		PrintWriter out = new PrintWriter(System.out);

		int n,i,j;
		String s,m,t,k;
		
		s=sc.nextLine();
		String arr[]= {"01:10","02:20","03:30","04:40","05:50","10:01","11:11","12:21","13:31","14:41","15:51","20:02","21:12","22:22","23:32","00:00","01:10"};
		
		m=s.substring(0,2);
		if(m.equals("06") || m.equals("07") || m.equals("08") || m.equals("09"))
			out.println(arr[5]);
		else if(m.equals("16") || m.equals("17") || m.equals("18") ||m.equals("19") )
			out.println(arr[11]);
		else {
		for(i=0;i<arr.length;i++) {
			if(m.equals(arr[i].substring(0,2))) {
				t=s.substring(3,5);
				k=arr[i].substring(3,5);
				if(t.compareTo(k)<0) {
					out.println(arr[i]);
					break;
				}
				else {
					out.println(arr[i+1]);
					break;
				}
			}
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
