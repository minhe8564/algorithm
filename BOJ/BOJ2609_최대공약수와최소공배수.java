/*
 * BOJ 2609번 : 최대공약수와 최소공배수
 * 메모리 : 11,544kb
 * 시간 : 68ms
 */

import java.io.*;
import java.util.*;

public class BOJ2609_최대공약수와최소공배수 {
	static int A, B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		sb.append(gcd(A, B)).append("\n"); // 최대공약수
		sb.append((A*B) / gcd(A, B)); // 최소공배수
		System.out.println(sb);
		br.close();
	}
	
	private static int gcd(int a, int b) {
		if(a%b==0) {
			return b;
		} else {
			return gcd(b, a%b);
		}
	}
}
