package algorithm;

import java.io.*;
import java.util.*;

public class BOJ2644_촌수계산 {
	static int[][] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 할아버지 - 아빠 - 나 (2촌)
		// 할아버지 - 아빠 형제들 - 나 (3촌)
		
		int N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		visited = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken())-1;
		int b = Integer.parseInt(st.nextToken())-1;
		int M = Integer.parseInt(br.readLine());
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			
			graph[x][y] = graph[y][x] = 1;
		}
		
		System.out.println(bfs(a, b));
		br.close();
	}
	
	// a시작 b를 찾으면 그 값이 촌수
	private static int bfs(int a, int b) {
		Queue<int[]> q = new ArrayDeque<>();
		visited[a] = true;
		q.offer(new int[] { a, 0 }); // 사람, 촌수
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int currPerson = curr[0];
			int currDistance = curr[1];
			
			if(currPerson == b) {
				return currDistance;
			}
			
			for(int i = 0; i < graph.length; i++) {
				if(graph[currPerson][i] == 1 && !visited[i]) {
					visited[i] = true;
					q.offer(new int[] { i, currDistance+1 });
				}
			}
		}
		
		return -1;
	}

}
