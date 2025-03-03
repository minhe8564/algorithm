/*
 * 1. 계단을 오를 때 1칸, 2칸 오르기 가능
 * 2. 1칸 3번 연속으로 불가능
 * 3. 마지막 계단은 반드시 밝아야 한다.
 */
package algorithm;

import java.io.*;
import java.util.*;

public class BOJ2579_계단오르기 {
	static int N;
	static int[] stair;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		stair = new int[N+1];
		for(int n = 1; n <= N; n++) {
			stair[n] = Integer.parseInt(br.readLine());
		}
		
		if(N==1) {
			System.out.print(stair[1]);
			return;
		}
		
		dp = new int[N+1];
		dp[1] = stair[1];
		dp[2] = stair[1]+stair[2];
		
		// 마지막 계단을 밟기 위한 경우 
		// 1. i-1에서 올라오는 경우 : i-2는 건너뛰어야 한다. 
		// 2. i-2에서 올라오는 경우
		for(int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i-3] + stair[i-1] + stair[i], dp[i-2] + stair[i]);
		}
		
		sb.append(dp[N]);
		System.out.print(sb);
		br.close();
	}

}
