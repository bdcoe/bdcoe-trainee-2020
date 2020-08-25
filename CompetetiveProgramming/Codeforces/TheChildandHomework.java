
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner; 
import java.util.StringTokenizer;

public class TheChildandHomework
{

	public static void main(String args[])
	{
		
		FastReader sc= new FastReader();

		int t,n,i,j;
		String s;
		int arr[]=new int[4];
		
		for(i=0;i<4;i++) {
			s=sc.nextLine();
			arr[i]=s.length()-2;
		}
		int b[]=Arrays.copyOf(arr, 4);
		Arrays.parallelSort(b);
		int low =b[0];
		int max=b[3];
		int flag1=0,flag2=0,pos;
		
			if(b[1]/low>=2 && b[2]/low>=2 && b[3]/low>=2) {
				flag1=1;
			}
			if(max/b[0]>=2 && max/b[1]>=2 && max/b[2]>=2) {
				flag2=1;
			}
		
		
		if((flag1==0 && flag2==0) || (flag1==1 && flag2==1))
		System.out.println("C");
		else {
			if(flag1==1) {
				for(i=0;i<4;i++) {
					if(arr[i]==low) {
						pos=i;
						break;
					}
				}
				if(i==0)
					System.out.println("A");
				if(i==1)
					System.out.println("B");
				if(i==2)
					System.out.println("C");
				if(i==3)
					System.out.println("D");
			}
			if(flag2==1) {
				for(i=0;i<4;i++) {
					if(arr[i]==max) {
						pos=i;
						break;
					}
				}
				if(i==0)
					System.out.println("A");
				if(i==1)
					System.out.println("B");
				if(i==2)
					System.out.println("C");
				if(i==3)
					System.out.println("D");
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
    } }
