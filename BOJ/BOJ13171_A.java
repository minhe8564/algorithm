/*
 * 백준 13171번 : A
 * 메모리 : 11,520kb
 * 시간 : 68ms
 * 
 * modular 연산
 * (a*b)%m = ((a%m)*(b%m))*m
 */

package algorithm;

import java.io.*;
import java.util.*;

public class BOJ13171_A {
	static long A, X;
	static final int MOD = 1_000_000_007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		A = Long.parseLong(br.readLine());
		X = Long.parseLong(br.readLine());
		
		sb.append(pow(A%MOD, X)); // 오버플로우 방지, 미리 MOD 연산적용 
		System.out.print(sb);
		br.close();
	}
	
	private static long pow(long A, long X) {
		if(X==0) {
			return 1;
		}
		
		long halfPow = pow(A, X/2); // 절반으로 나눈 거듭제곱 
		long squared = (halfPow*halfPow) % MOD; // 제곱 후 MOD 연산 
		
		if(X%2==0) {
			return squared;
		} else {
			return (A*squared) % MOD; // 추가 곱셈 
		}
	}
}
