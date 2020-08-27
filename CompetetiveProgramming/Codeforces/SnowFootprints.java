
import java.io.*; 
import java.util.*; 


public class SnowFootprints
{

	public static void main(String args[])
	{
		
		FastReader sc= new FastReader();
		PrintWriter out = new PrintWriter(System.out);

		int t,n,i,j,pos=0;
		String s;
		int flagR=0,flagL=0,flag=0;
		String p="",m="";
		n=sc.nextInt();
		s=sc.nextLine();
		char arr[]=s.toCharArray();
		
		for(i=0;i<arr.length;i++) {
			if(arr[i]!='.') {
				p=String.valueOf(arr[i]);
				pos=i;
				break;
			}
		}
		
		for(i=pos+1;i<arr.length;i++) {
			m=String.valueOf(arr[i]);
			if(m.equals(p) || m.equals(".")) {
				continue;
			}
			else
			{
				flag=1;
				break;
			}
		}
		
		if(flag==0 && p.equals("L")) {
			for(i=arr.length-1;i>=0;i--) {
				if(arr[i]=='.' && arr[i-1]=='L') {
					out.println((i)+" "+(pos));
					break;
				}
			}
		}
		if(flag==0 && p.equals("R")) {
			for(i=pos+1;i<arr.length;i++) {
				if(arr[i-1]=='R' && arr[i]=='.') {
					out.println((pos+1)+" "+(i+1));
					break;
				}
			}
		}
		
		if(flag==1) {
			for(i=pos+1;i<arr.length;i++) {
				if(arr[i]=='L' && arr[i-1]=='R') {
					out.println((pos+1)+" "+(i+1));
				break;
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
