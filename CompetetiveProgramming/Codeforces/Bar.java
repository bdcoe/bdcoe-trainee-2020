

import java.io.*; 
import java.util.*; 


public class Bar
{

	public static void main(String args[])
	{
		
		FastReader sc= new FastReader();
		PrintWriter out = new PrintWriter(System.out);

		int n,i,j;
		String s;
		
		String alc[]= {"ABSINTH","BEER","BRANDY","CHAMPAGNE","GIN","RUM","SAKE","TEQUILA","VODKA","WHISKEY","WINE"};
		
		int count=0;
		n=sc.nextInt();
		
		while(n-->0) {
		s=sc.nextLine();
		char p=s.charAt(0);
		int flag=0;
		
		if(p>='0' && p<='9') {
			int m=Integer.parseInt(s);
			if(m<18)
				count++;
		}
		else {
			for(i=0;i<alc.length;i++) {
				if(s.equals(alc[i])) {
					count++;
					break;
				}
			}
		}
		
		}
		out.println(count);
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
