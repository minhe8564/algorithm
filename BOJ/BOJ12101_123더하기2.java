package algorithm;

import java.io.*;
import java.util.*;

// 1, 2, 3 더하면서 N을 만드는 모든 경우 찾기
// K번째 경우 찾으면 졸료
// sum > N이면 종료 -> 백트래킹

public class BOJ12101_123더하기2 {
	static int N, K;
	static int cnt;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		cnt = 0;
		dfs(0, "");
		
		System.out.println(-1);
		br.close();
	}
	
	private static void dfs(int sum, String expr) { // 합, 현재까지 만든 숫자 조합
		if(sum > N) {
			return;
		}
		if(sum == N) { // 정답을 찾은 경우
			cnt++;
			if(cnt == K) { // K번째 수식을 찾은 경우
				System.out.print(expr.substring(0, expr.length()-1));
				System.exit(0); // 프로그램 즉시 종료
			}
		}
		
		for(int i = 1; i <= 3; i++) {
			dfs(sum+i, expr+i+"+");
		}
	}
	
	

}
