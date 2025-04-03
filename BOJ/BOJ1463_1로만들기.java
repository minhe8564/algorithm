/*
 * BOJ 1463번 : 1로 만들기
 * 메모리 : 15,560kb
 * 시간 : 100ms
 */

import java.io.*;
import java.util.*;

public class BOJ1463_1로만들기 {
	static int N;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		
		dp[0] = 0;
		dp[1] = 0;
		
		for(int n = 2; n <= N; n++) {
			dp[n] = dp[n-1]+1;
			
			if(n%2==0) {
				dp[n] = Math.min(dp[n], dp[n/2]+1);
			} 
			
			if(n%3==0) {
				dp[n] = Math.min(dp[n], dp[n/3]+1);
			}
		}
		
		sb.append(dp[N]);
		System.out.println(sb);
		br.close();
	}
}
