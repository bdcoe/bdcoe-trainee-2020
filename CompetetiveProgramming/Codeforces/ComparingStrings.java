
import java.io.*; 
import java.util.*; 


public class ComparingStrings
{

	public static void main(String args[])
	{
		
		FastReader sc= new FastReader();
		PrintWriter out = new PrintWriter(System.out);

		int i,j,count=0;
		String s,p,ans;
		List<Integer> pos=new ArrayList<>();
		List<Character> ch=new ArrayList<>();
		s=sc.nextLine();
		p=sc.nextLine();
		if(s.length()!=p.length())
			out.println("NO");
		else {	
		for(i=0;i<s.length();i++) {
			char m=s.charAt(i);
			char r=p.charAt(i);
			if(m!=r) {
				count++;
				pos.add(i);
				ch.add(m);
			}
		}
		if(count!=2)
		out.println("NO");
		else
		{
			
			ans=s.substring(0,pos.get(0));
			ans=ans+ch.get(1);
			ans=ans+s.substring(pos.get(0)+1,pos.get(1));
			ans=ans+ch.get(0);
			ans=ans+s.substring(pos.get(1)+1,s.length());
			if(ans.equals(p)) {
				out.println("YES");
			}
			else
				out.println("NO");
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
