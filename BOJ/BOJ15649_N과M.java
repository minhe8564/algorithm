package algorithm;

import java.io.*;
import java.util.*;

public class BOJ15649_N과M {
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static boolean[] visited;
	static int[] num;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 1~N까지 자연수 중에서 중복없이 M개를 고른 순열
		num = new int[M];
		visited = new boolean[N];
		dfs(0);
		System.out.println(sb);
		br.close();
	}
	
	private static void dfs(int depth) {
		if(depth == M) {
			// 출력
			for(int i : num) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				num[depth] = i + 1;
				dfs(depth+1);
				visited[i] = false;
			}
		}
	}
	

}
