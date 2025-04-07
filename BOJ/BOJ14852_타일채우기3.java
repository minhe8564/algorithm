/*
 * BOJ 14852번 : 타일 채우기3
 * 메모리 : 27,288kb
 * 시간 : 96ms
 * 
 * dp[1] = 2
 * dp[2] = 7 
 * dp[3] = dp[2]*2 + dp[1]*3 + 2*dp[0] = 22
 * 
 * dp[n] = dp[n-1]*2 + dp[n-2]*3 + 2*(dp[0]+dp[1]+ ... + dp[n-3])
 */

import java.io.*;
import java.util.*;

public class BOJ14852_타일채우기3 {
	static int N;
	static long[] dp;
	static long[] sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		dp = new long[1_000_001];
		dp[0] = 1;
		dp[1] = 2;
		dp[2] = 7;
		
		sum = new long[1_000_001];
		sum[0] = dp[0]; // 1
		sum[1] = sum[0] + dp[1]; // 3
		sum[2] = sum[1] + dp[2]; // 10

		for(int i = 3; i <= N; i++) {
			dp[i] = (dp[i-1]*2 + dp[i-2]*3 + 2*sum[i-3]) % 1_000_000_007;
			sum[i] = (sum[i-1] + dp[i]) % 1_000_000_007;
		}
		
		sb.append(dp[N]);
		System.out.print(sb);
		br.close();
	}
}
