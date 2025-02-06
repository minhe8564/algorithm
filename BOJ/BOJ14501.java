package algorithm;

import java.io.*;
import java.util.*;

public class BOJ14501 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] T = new int[N];
		int[] P = new int[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N + 1]; // 수익 저장, N+1 -> 마지막 날까지 고려

		for (int i = 0; i < N; i++) {
			if (i+ T[i] <= N) { // 현재 날짜에서 상담이 가능한지 확인
				sb.append(i+T[i]);
				dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
			}
			dp[i+1] = Math.max(dp[i+1], dp[i]); // 상담을 선택하지 않고, 다음 날짜로 넘어갈 때 수익 유지
		}
		
		// i=0, dp[3] = max(dp[3], dp[0]+10) = 10 
		// i=1, dp[6] = max(dp[6], dp[1]+10) = 20
		// i=2, dp[3] = max(dp[3], dp[2]+10) = 10
		// i=3, dp[4] = max(dp[4], dp[3]+20) = 30
		// i=4, dp[6] = max(dp[6], dp[4]+15) = 45
		// i=5, N=7 초과
		// i=6, N=7 초과
		
		sb.append(dp[N]);
		System.out.println(sb);
		br.close();
	}

}
