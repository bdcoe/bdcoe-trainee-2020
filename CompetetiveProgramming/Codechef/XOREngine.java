
import java.io.*;
public class XOREngine {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		
		try{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					
					int i,t,n,count,m,countev,countod,q,j;
					countev=count=countod=0;
					long k;
					String s;
					
					
					t=Integer.parseInt(br.readLine());
					
					while(t-->0) {
						n=Integer.parseInt(br.readLine());
						q=Integer.parseInt(br.readLine());
						int a[]=new int[n];
						
						
						for(i=0;i<n;i++) 
							a[i]=Integer.parseInt(br.readLine());
						
						
						while(q-->0) {
						m=Integer.parseInt(br.readLine());
							for(i=0;i<n;i++) {
								k=m^a[i];
							s=Long.toBinaryString(k);
							for(j=0;j<s.length();j++) {
								char p=s.charAt(j);
								if(p=='1')
									count++;
							}
							if(count%2==0)
								countev++;
							else
								countod++;
							count=0;
						}
							System.out.println(countev+" "+countod);
							countev=countod=0;
						}
						}
					}catch(Exception e){
					    return;
					}			

	}

}
