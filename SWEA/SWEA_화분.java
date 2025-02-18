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
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			A = new int[N];
			B = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				B[i] = Integer.parseInt(st.nextToken());
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

		// sum을 밖에서 수정하면 다른 재귀 호출에도 영향을 준다...
		// A 선택
//		if(prev == 1) 
//			sum += A[idx] - P;
//		else
//			sum += A[idx];
//		dfs(idx+1, sum, 1);
		
		// 음수 방지하기 위해서
		// Math.max(A[idx]-P, 0) 해줘야 함!!!
	    dfs(idx+1, sum + (prev==1 ? Math.max(A[idx]-P, 0) : A[idx]), 1);


		// B 선택
//		if(prev == 2) 
//			sum += B[idx] - P;
//		else
//			sum += B[idx];
//		dfs(idx+1, sum, 2);
	    dfs(idx+1, sum + (prev==2 ? Math.max(B[idx]-P, 0) : B[idx]), 2);
	    
	    
		
	}

}
