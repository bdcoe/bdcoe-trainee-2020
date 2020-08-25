
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer;

public class Lever
{

	public static void main(String args[])
	{
		
		FastReader sc= new FastReader();

		int t,n,i,j,pivotpos=0;
		long suml=0,sumr=0;
		String s;
		
		s=sc.nextLine();
		int len =s.length();
		
		for(i=0;i<len;i++) {
			char p=s.charAt(i);
			if(p=='^') {
				pivotpos=i;
				break;
			}
		}
		for(i=0;i<pivotpos;i++) {
			char p=s.charAt(i);
			if(p>='1' && p<='9') {
				suml+=Math.abs(pivotpos-i)*Integer.parseInt(String.valueOf(p));
			}	
		}
		for(i=pivotpos+1;i<len;i++) {
			char p=s.charAt(i);
			if(p>='1' && p<='9') {
				sumr+=Math.abs(pivotpos-i)*Integer.parseInt(String.valueOf(p));
			}	
		}
		
		if(suml>sumr)
			System.out.println("left");
		else if(sumr>suml)
			System.out.println("right");
		else
			System.out.println("balance");
		
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
