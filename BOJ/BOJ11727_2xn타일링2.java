/*
 * BOJ 11727번 : 2xn 타일링2
 * 메모리 : 11,536kb
 * 시간 : 68ms
 * 
 * 점화식
 * f(n) = f(n-2)+f(n-2)+f(n-1)
 */

import java.io.*;
import java.util.*;

public class BOJ11727_2xn타일링2 {
	static int N;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		
		dp[0] = 1;
		dp[1] = 1;
		
		for(int n = 2; n <= N; n++) {
			dp[n] = (dp[n-2]+dp[n-2]+dp[n-1])%10007;
		}
		
		sb.append(dp[N]);
		System.out.println(sb);
		br.close();
	}
}
