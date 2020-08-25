

import java.util.*;
import java.util.Collections;

public class AntonandPolyhedrons
{
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);

		int n,i,faces;
		String s;
		faces=0;

		n=sc.nextInt();
		sc.nextLine();
		String arr[]= {"Tetrahedron","Cube","Octahedron","Dodecahedron","Icosahedron"};
		int b[]= {4,6,8,12,20};
		
		while(n-->0) {
			s=sc.nextLine();
			for(i=0;i<arr.length;i++) {
				if(s.equals(arr[i]))
					faces+=b[i];
			}
		}
		
		System.out.println(faces);

		sc.close();
	}
}

