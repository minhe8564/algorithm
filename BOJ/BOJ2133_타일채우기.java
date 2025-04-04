/*
 * BOJ 2133번 : 타일채우기
 * 메모리 : 11,548kb
 * 시간 : 68ms
 * 
 * dp[1] = 0
 * dp[2] = 3
 * dp[3] = 0
 * dp[4] = dp[2]*2+2 = 11
 * dp[5] = 0
 * dp[6] = dp[2]*dp[4]+dp[2]*2+2 = 41
 * dp[7] = 0
 * dp[8] = dp[2]*dp[6]+dp[4]*2+2 = 153
 * 
 * dp[n] = dp[2]*dp[n-2] + dp[n-4]*2 + dp[n-6]*2 + dp[n-8]*2 + ..... + dp[n-(n-2)]*2 + 2;
 * dp[n-2] = dp[2]*dp[n-4] + dp[n-6]*2 + ..... + dp[n-(n-2)]*2 + 2;
 * dp[n]-dp[n-2] = dp[2]*dp[n-2] - dp[n-4]
 * dp[n] = 4*dp[n-2] - dp[n-4]
 */

import java.io.*;
import java.util.*; 

public class BOJ2133_타일채우기 {
	static int N;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		dp = new int[31];
		
		dp[1] = 0;
		dp[2] = 3;
		dp[3] = 0;
		dp[4] = 11;
		
		for(int i = 5; i <= N; i++) {
			if (i%2!=0) dp[i] = 0;
			else dp[i] = dp[i-2]*4-dp[i-4];			
		}
		
		sb.append(dp[N]);
		System.out.print(sb);
		br.close();
	}
}
