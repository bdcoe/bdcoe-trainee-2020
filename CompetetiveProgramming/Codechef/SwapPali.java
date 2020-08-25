import java.util.Scanner;
public class SwapPali {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner sc=new Scanner(System.in);
		
		int t,n,i,j,count,flag;
		count=flag=0;
		char p,q;
		String temp,mvs,b,lol;
		temp="";
		
		t=sc.nextInt();
		while(t-->0) {
			n=sc.nextInt();
			sc.nextLine();
			String s=sc.next();
			mvs=s;
			for(i=0;i<n-1;i++) {
				
				p=s.charAt(i);
				q=s.charAt(i+1);
				count++;
				temp=temp+(char)q+(char)p+s.substring(i+2,n);
				b=temp;
				if(i!=0) {
					b=s.substring(0,i)+temp;
				}
				StringBuilder ans=new StringBuilder();
				ans.append(b);
				ans=ans.reverse();
				lol=ans.toString();
				if(b.equals(lol)) {
					System.out.println("YES");
					System.out.println(count);
					flag=1;
					break;
				}else {
					temp="";
					b="";
					count=0;
				}
				
			}
			if(flag==0) {
				System.out.println("NO");
			}
			
			count=0;temp="";flag=0;
		}
		sc.close();

	}

}
