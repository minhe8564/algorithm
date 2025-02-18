package algorithm;

import java.io.*;
import java.util.*;

public class BOJ1697_숨바꼭질 {
	static int N, K;
	static int answer;
	static boolean[] visited = new boolean[100001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 수빈이 X
		// 1초 후 X-1 또는 X+1 이동
		// 순간이동 2*X 이동
		
		sb.append(bfs());
		System.out.println(sb);
		br.close();
	}

// dfs로 풀 경우 StackOverFlow 발생!!!
//	private static void dfs(int curr, int time) {
//		if(curr == K) {
//			answer = Math.min(answer, time);
//			return;
//		}
//		
//		// 현재 위치가 이미 방문한 곳이라면 더 이상 진행하지 않는다.
//		if(curr < 0 || curr > 100000 || visited[curr]) {
//			return;
//		}
//		
//		visited[curr] = true;
//		
//		dfs(curr-1, time+1);
//		dfs(curr+1, time+1);
//		dfs(curr*2, time+1);
//
//		visited[curr] = false;
//	}
	
	private static int bfs() {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] { N, 0 }); // 현재 위치, 시간
		visited[N] = true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int prev = curr[0];
			int time = curr[1];
			
			if(prev == K) {
				return time;
			}
			
			// 이동 가능한 3가지 경우
			if (prev-1 >= 0 && prev-1 <= 100000 && !visited[prev-1]) {
				visited[prev-1] = true;
				q.add(new int[] { prev-1, time+1 });
			}
			if (prev+1 >= 0 && prev+1 <= 100000 && !visited[prev+1]) {
				visited[prev+1] = true;
				q.add(new int[] { prev+1, time+1 });
			}
			if (prev*2 >= 0 && prev*2 <= 100000 && !visited[prev*2]) {
				visited[prev*2] = true;
				q.add(new int[] { prev*2, time+1 });
			}
			
		}
		
		return -1;
	}

}
