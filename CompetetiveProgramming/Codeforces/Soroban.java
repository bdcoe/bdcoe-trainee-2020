
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer;

public class Soroban
{

	public static void main(String args[])
	{
		
		FastReader sc= new FastReader();

		int t,n,i,j,l;
		String s;

		n=sc.nextInt();
		
		s=Integer.toString(n);
		for(i=s.length()-1;i>=0;i--) {
			char p=s.charAt(i);
			int temp=Integer.parseInt(String.valueOf(p));
			if(temp<5 && temp!=0) {
				System.out.print("O-|");
				for(j=1;j<=temp;j++)
					System.out.print("O");
				int k=4-temp; 
				if(k>0)
					System.out.print("-");
				for(l=1;l<=k;l++) 
					System.out.print("O");
				if(temp==4)
					System.out.print("-");
				System.out.println();
		}
			if(temp==0)
				System.out.println("O-|-OOOO");
			if(temp>=5) {
				System.out.print("-O|");
				for(j=1;j<=temp-5;j++)
					System.out.print("O");
				int k=9-temp;
				if(k>0)
					System.out.print("-");
				for(l=1;l<=k;l++)
					System.out.print("O");
				if(temp==9)
					System.out.print("-");
				System.out.println();
			}
		}
			
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