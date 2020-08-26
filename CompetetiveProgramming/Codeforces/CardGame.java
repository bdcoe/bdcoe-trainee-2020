
import java.io.*; 
import java.util.*; 


public class CardGame
{

	public static void main(String args[])
	{
		
		FastReader sc= new FastReader();
		PrintWriter out = new PrintWriter(System.out);

		int i;
		String first,second;
		char rank[]= {'6','7','8','9','T','J','Q','K','A'};
		
		char tramp=sc.nextLine().charAt(0);
		String s=sc.nextLine();
		first=s.substring(0,2);
		second=s.substring(3,5);
		
		if(first.charAt(1)!=tramp && second.charAt(1)!=tramp  && first.charAt(1)!=second.charAt(1)) { 
			out.println("NO");
		}
		else
		{
		if(first.charAt(1)==tramp && second.charAt(1)==tramp) {
			char m=first.charAt(0);
			char p=second.charAt(0);
			int rankf=0,ranks=0;
			for(i=0;i<rank.length;i++) {
				if(rank[i]==m)
					rankf=i;
				if(rank[i]==p)
					ranks=i;
			}
			if(rankf<=ranks)
				out.println("NO");
			else
				out.println("YES");
		}
		if(first.charAt(1)==tramp && second.charAt(1)!=tramp) 
			out.println("YES");
		
		if(first.charAt(1)!=tramp && second.charAt(1)==tramp) 
			out.println("NO");
		
		if(first.charAt(1)!=tramp && second.charAt(1)!=tramp) {
			char m=first.charAt(0);
			char p=second.charAt(0);
			int rankf=0,ranks=0;
			for(i=0;i<rank.length;i++) {
				if(rank[i]==m)
					rankf=i;
				if(rank[i]==p)
					ranks=i;
			}
			if(rankf<=ranks)
				out.println("NO");
			else
				out.println("YES");
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
