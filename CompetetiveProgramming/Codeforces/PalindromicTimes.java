
import java.io.*; 
import java.util.*; 


public class PalindromicTimes
{

	public static void main(String args[])
	{
		
		FastReader sc= new FastReader();
		PrintWriter out = new PrintWriter(System.out);

		int t,n,i,j;
		String s,m;
		
		s=sc.nextLine();
		m=s.substring(0,2)+s.substring(3,5);
		n=Integer.parseInt(m);
		int temp,temp2=0,ans=0,flag=0;
		for(i=n+1;i<=2332;i++) {
			if(i>100) {
				temp=i;
				temp2=temp;
				while(temp>0) {
					int dig=temp%10;
					temp/=10;
					ans=ans*10+dig;
				}
				if(ans==temp2) {
					flag=1;
					break;
				}
				ans=0;
			}
			if(flag==1)
				break;
		}
		if(flag==0)
			out.print("00:00");
		else {
			String a="";
			if(temp2<=1000) {
				 a=Integer.toString(temp2);
				a="0"+a;
			}
			else {
				a=Integer.toString(temp2);
			}
		out.println(a.substring(0,2)+":"+a.substring(2,4));
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
