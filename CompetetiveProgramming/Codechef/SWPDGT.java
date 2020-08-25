import java.util.Scanner;

public class SWPDGT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int t,a,b,max,temp;
		max=temp=0;
		char k,l,m,n;
		String x,y,st,st2;
		st="";
		st2="";
		int xlen,ylen;
		t=sc.nextInt();
		
		while(t-->0) {
			a=sc.nextInt();
			b=sc.nextInt();
			max=a+b;
			
			x=Integer.toString(a);
			y=Integer.toString(b);
			xlen=x.length();
			ylen=y.length();
			
			if(xlen==1 && ylen==2) {
				x=x+y.charAt(0);
				char p=y.charAt(1);
				temp=Integer.parseInt(x)+Integer.parseInt(String.valueOf(p));
				if(temp>max)
					max=temp;
			}
			if(xlen==2 && ylen==1) {
				y=y+x.charAt(0);
				char p=x.charAt(1);
				temp=Integer.parseInt(y)+Integer.parseInt(String.valueOf(p));
				if(temp>max)
					max=temp;
			}
			if(xlen==2 && ylen==2) {
				
				k=y.charAt(1);
				l=x.charAt(1);
				m=y.charAt(0);
				n=x.charAt(0);
				
				st=st+k+l;
				st2=st2+m+n;
				temp=Integer.parseInt(st)+Integer.parseInt(st2);
				if(temp>max)
					max=temp;
				st="";
				st2="";
				
				k=y.charAt(0);
				l=x.charAt(1);
				m=x.charAt(0);
				n=y.charAt(1);
				
				st=st+k+l;
				st2=st2+m+n;
				temp=Integer.parseInt(st)+Integer.parseInt(st2);
				if(temp>max)
					max=temp;
				st="";
				st2="";
				
				
				k=x.charAt(0);
				l=y.charAt(1);
				m=x.charAt(1);
				n=y.charAt(1);
				st=st+k+l;
				st2=st2+m+n;
				temp=Integer.parseInt(st)+Integer.parseInt(st2);
				if(temp>max)
					max=temp;
				st="";
				st2="";
				
				
				
				k=x.charAt(0);
				l=y.charAt(1);
				m=y.charAt(0);
				n=x.charAt(1);
								
				st=st+k+l;
				st2=st2+m+n;
				temp=Integer.parseInt(st)+Integer.parseInt(st2);
				if(temp>max)
					max=temp;
				st="";
				st2="";
				
				
				
				
			}
			System.out.println(max);
		}
sc.close();
	}

}
