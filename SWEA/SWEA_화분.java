package algorithm;

import java.io.*;
import java.util.*;

public class SWEA_화분 {
	static int N, P;
	static int[] A;
	static int[] B;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			N = Integer.parseInt(st.nextToken()); // 화분의 수
			P = Integer.parseInt(st.nextToken()); // 동일한 비료를 연속으로 주었을 때 P만큼 덜 자란다.
			A = new int[N];
			B = new int[N];
			
			st = new StringTokenizer(br.readLine().trim(), " ");
			for(int n = 0; n < N; n++) {
				A[n] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine().trim(), " ");
			for(int n = 0; n < N; n++) {
				B[n] = Integer.parseInt(st.nextToken());
			}

			answer = Integer.MIN_VALUE;
			dfs(0, 0, 0);
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	private static void dfs(int idx, int sum, int prev) {
		if(idx == N) {
			answer = Math.max(answer, sum);
			return;
		}
		
		// A 비료 선택한 경우
		dfs(idx+1, prev==1 ? sum + A[idx]-P : sum + A[idx], 1);
		// B 비료 선택한 경우
		dfs(idx+1, prev==2 ? sum + B[idx]-P : sum + B[idx], 2);
		
	}

}
