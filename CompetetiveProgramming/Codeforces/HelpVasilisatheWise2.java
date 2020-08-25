

import java.io.*; 
import java.util.*; 


public class HelpVasilisatheWise2
{

	public static void main(String args[])
	{
		
		FastReader sc= new FastReader();
		PrintWriter out = new PrintWriter(System.out);

		int i,j,r1,r2,c1,c2,d1,d2,flag=0;
		String s;

		r1=sc.nextInt();
		r2=sc.nextInt();
		c1=sc.nextInt();
		c2=sc.nextInt();
		d1=sc.nextInt();
		d2=sc.nextInt();
		int num1=0,n1=0,num2=0,n2=0;
		for(i=1;i<Math.ceil(r1/2.0);i++) {
			for(j=1;j<Math.ceil(r2/2.0);j++) {
				num1=i;n1=r1-i;
				num2=j;n2=r2-j;
				if(num1>0 &&num1<10 && n1>0 && n1<10 && num2>0 && num2<10 && n2>0 && n2<10 && num1!=n1 && num1!=n2 && num1!=num2 && n1!=n2 && n1!=num2 && n2!=num2) {
				if((num1+num2==c1) && (n1+n2==c2) && (num1+n2==d1) && (n1+num2==d2)){
					flag=1;
					out.println(num1+" "+n1+"\n"+num2+" "+n2);
					break;
				}
				if((n1+num2==c1)  && (num1+n2==c2) && (n1+n2==d1) && (num1+num2==d2)){
					flag=1;
					out.println(n1+" "+num1+"\n"+num2+" "+n2);
					break;
				}
				if((num1+n2==c1) && (n1+num2==c2 ) && (num1+num2==d1) && (n1+n2==d2)){
					flag=1;
					out.println(num1+" "+n1+"\n"+n2+" "+num2);
					break;
				}
				if((n1+n2==c1 )&& (num1+num2==c2) && (n1+num2==d1) && (num1+n2==d2)) {
					flag=1;
					out.println(n1+" "+num1+"\n"+n2+" "+num2);
					break;
				}
			}
			}
			if(flag==1)
				break;
		}
		if(flag!=1)
		out.println(-1);
		
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
