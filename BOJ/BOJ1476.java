package algorithm;

import java.io.*;
import java.util.*;

public class BOJ1476 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken()); // 1~15
		int S = Integer.parseInt(st.nextToken()); // 1~28
		int M = Integer.parseInt(st.nextToken()); // 1~19
		int e = 0;
		int s = 0;
		int m = 0;
		int year = 0;
		while(true) {
			year++;
			e++;
			s++;
			m++;
			
			if(e == 16) e=1;
			if(s == 29) s=1;
			if(m == 20) m=1;
			if(E==e && S==s && M==m) break;
		}
		
		System.out.println(year);
		br.close();
	}

}
