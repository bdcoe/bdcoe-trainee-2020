/*
 * 
 * WA
 * */

import java.io.*; 
import java.util.*; 


public class GuessANumber
{

	public static void main(String args[])
	{
		
		FastReader sc= new FastReader();
		PrintWriter out = new PrintWriter(System.out);

		int t,n,i,j,pos=0,imp=0;
		String s,relation="",condition;
		int number=0,maximum=Integer.MAX_VALUE,minimum=Integer.MIN_VALUE;
		
		n=sc.nextInt();
		
		while(n-->0) {
		s=sc.nextLine();
		condition=String.valueOf(s.charAt(s.length()-1));
		int flag=0,flag1=0;
		for(i=0;i<s.length()-1;i++) {
			char p=s.charAt(i);
			if(p==' ' && flag==0) {
				relation=s.substring(0,i);
				pos=i;
				flag=1;
			}
			if(p==' ' && flag1==1) 
				number=Integer.parseInt(s.substring(pos+1,i));
			
			if(flag==1)
				flag1=1;
		}
		
		if ( condition.equals("N")) {
			if (relation.equals(">="))
				relation = "<";
			else if (relation.equals("<"))
				relation= ">=";
			else if (relation.equals("<=")) 
				relation= ">";
			else
				relation= "<=";
		}
		
		if(relation.equals(">="))
			minimum=Math.max(minimum, number);
		else if(relation.equals(">"))
			minimum=Math.max(minimum, number+1);
		else if(relation.equals("<="))
			maximum=Math.min(maximum, number);
		else
			maximum=Math.min(maximum, number-1);
		
		}
		if(minimum<=maximum) 
			out.println(minimum);
		else
			out.println("Impossible");
			
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
