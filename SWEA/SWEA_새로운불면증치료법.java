/*
 * SWEA : 새로운 불면증 치료법
 * 메모리 : 25,344kb
 * 시간 : 79ms
 */

import java.io.*;
import java.util.*;

public class SWEA_새로운불면증치료법 {
	static int[] num;
	static String N;
	static int N_int;
	static boolean stop;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			num = new int[10];
			N = br.readLine();
			N_int = Integer.parseInt(N);
			int temp = Integer.parseInt(N);
			
			while(true) {
				for(int i = 0; i < N.length(); i++) {
					num[N.charAt(i)-'0']++;
				}
				
				stop = true;
				for(int i = 0; i < 10; i++) {
					if(num[i]==0) stop = false;
				}
				if(stop) break;
				
				N_int += temp;
				N = Integer.toString(N_int);
			}
			
			sb.append(N).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
