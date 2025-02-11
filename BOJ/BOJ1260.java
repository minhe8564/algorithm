package algorithm;

import java.io.*;
import java.util.*;

public class BOJ1260 {
	static int N;
	static int[][] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		int V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호
		arr = new int[N+1][N+1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = arr[b][a] = 1;
		}
		
		// DFS 재귀
		visited = new boolean[N+1];
		dfs(V);
		sb.append("\n");
		
		// BFS 큐
		visited = new boolean[N+1];
		bfs(V);
		
		System.out.println(sb);
		br.close();
	}
	
	private static void dfs(int v) {
		sb.append(v).append(" ");
		visited[v] = true;
		
		for(int i = 1; i <= N; i++) {
			if(arr[v][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}
	
	private static void bfs(int v) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			sb.append(curr).append(" ");
			
			for(int i = 1; i <= N; i++) {
				if(arr[curr][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		
	}

}

